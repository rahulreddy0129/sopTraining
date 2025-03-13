package com.sop.sopSample.service;

import com.google.gson.Gson;
import com.sop.sopSample.DTO.SopDTO;
import com.sop.sopSample.config.Constants;
import com.sop.sopSample.exception.SopException;
import com.sop.sopSample.model.Tm;
import com.sop.sopSample.model.TmType;
import com.sop.sopSample.model.Training;
import com.sop.sopSample.model.TrainingTm;
import com.sop.sopSample.repository.TmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TmService {

    @Autowired
    private TmRepository tmRepository;

    @Autowired
    private TmJobcodeService tmJobcodeService;

    @Autowired
    private SopDataService dataService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingAttachmentService trainingAttachmentService;

    @Autowired
    private TrainingTmService trainingTmService;

    public Tm createSop(SopDTO sopData, MultipartFile file) {
        Long departmentId = sopData.getTrainingId();
        Training training = validateAndFetchTraining(departmentId);

        Tm tm = prepareSop(new Tm(), sopData, training);
        tm = tmRepository.save(tm);

        saveAttachmentIfpresent(tm, file, sopData.getId());

        tmJobcodeService.creataTmJobcodes(tm, sopData.getJobCodeIds(), LocalDate.now());

        TrainingTm trainingTm = createTrainingTmAssosation(training, tm, sopData.getEffectiveDate());

        Map<String, Object> resMap = createAndAssignUserTraining(tm, trainingTm, sopData.getJobCodeIds());


        return tm;
    }

    public Tm prepareSop(Tm tm, SopDTO sopData, Training training) {
        tm.setName(sopData.getName());
        tm.setTrainingHours(sopData.getTrainingHours());
        tm.setTrainingMinutes(sopData.getTrainingMinutes());
        tm.setTraining(training);
        tm.setSop(true);
        tm.setSopNumber(sopData.getSopNumber());
        tm.setSopVersion(String.valueOf(Optional.ofNullable(sopData.getSopVersion()).orElse(1)));

        if(sopData.getId() != null) {
            if(!Objects.equals(sopData.getId(), tm.getId())) {
                tm.setPrevSop(sopData.getId());
            }
        }
        if(sopData.getSopTmType() != null) {
            TmType tmType = dataService.getTmTypeId(sopData.getSopTmType());
            tm.setTmType(tmType);
        }

        handlePlannndAndEffectiveDates(tm, sopData);
        tm.setDeptId(training.getDeptId());
        setExamDetails(tm, sopData);
        tm.setJobcodes(convertToJSON(Map.of("Jobcodes", sopData.getJobCodeIds())));

        return tm;
    }

    private void setExamDetails(Tm tm, SopDTO sopData) {
        if("Yes".equalsIgnoreCase(sopData.getIsExamRequired())) {
            tm.setRequireExam(true);
            validateExamDetails(sopData);
            tm.setNoOfQuestions(sopData.getTotalQuestions());
            tm.setExamQuestions(sopData.getRequiredQuestionsCount());
            tm.setCorrectAnswersRequired(sopData.getCorrectAnswersCount());
            tm.setQuestions(convertToJSON(sopData.getQuestionList()));
        } else {
            tm.setRequireExam(false);
        }
    }

    private void validateExamDetails(SopDTO sopData) {
        if(
            sopData.getTotalQuestions() == null || sopData.getCorrectAnswersCount() == null || sopData.getRequiredQuestionsCount() == null
        ) {
            throw new SopException("Mandatory exam details missing when 'Require Exam' is set to Yes.");
        }
    }

    private void handlePlannndAndEffectiveDates(Tm tm, SopDTO sopData) {
        if(sopData.getPlannedDate() != null && !sopData.getPlannedDate().equals("") && !sopData.getPlannedDate().equals("-")) {
            tm.setPlannedDate(concertStringToLocalDate(sopData.getPlannedDate()));
            tm.setStatus(dataService.getStatusName(Constants.STATUS_IN_INPROGRESS));
        }
        if(sopData.getEffectiveDate() != null && !sopData.getEffectiveDate().equals("") && !sopData.getEffectiveDate().equals("-")) {
            tm.setEffectiveDate(concertStringToLocalDate(sopData.getEffectiveDate()));
            tm.setThruDate(LocalDate.now().plusYears(3));
            tm.setStatus(dataService.getStatusName(Constants.STATUS_TM_ACTIVE));
        }
    }

    public Training validateAndFetchTraining(Long departmnetId) {
        List<Training> training = trainingService.getTrainingcategoryNameAndDepartment(Constants.TC_ROLE_BASED, departmnetId);
        if (training.isEmpty()) {
            String deptName = getpsNameById(departmnetId);
            return trainingService.createTraining(deptName, Constants.TC_ROLE_BASED, deptName, departmnetId, Boolean.TRUE, Boolean.TRUE);
        }
        return training.get(0);
    }


    public void saveAttachmentIfpresent(Tm tm, MultipartFile file, Long id) {
        if(file != null && !file.isEmpty()) {
            trainingAttachmentService.createTmAttachment(tm, file, id);
        }
    }

    public TrainingTm createTrainingTmAssosation(Training training, Tm tm, String effectiveDate) {
        TrainingTm trainingTm = new TrainingTm();
        trainingTm.setTraining(training);
        trainingTm.setTm(tm);

        if(effectiveDate != null && !effectiveDate.equals("") && !effectiveDate.equals("-")) {
            trainingTm.setFromDate(concertStringToLocalDate(effectiveDate));
            trainingTm.setThruDate(concertStringToLocalDate(effectiveDate).plusYears(3));
        }
        return trainingTmService.save(trainingTm);
    }

    public Map<String, Object> createAndAssignUserTraining(Tm tm, TrainingTm trainingTm, List<Long> jobCodeIds) {
        List<Map<String, Object>> applicablePartyList = new ArrayList<Map<String, Object>>();
        String statusName = tm.getStatus().getName();
//        if (statusName.equals(Constants.STATUS_TM_INPROGRESS)) {
//            applicablePartyList = mastersDataService.getPartyDetailsByJobCodes(jobCodeIdList);
//        } else {
//            applicablePartyList = mastersDataService.getNewJoineePartyDetailsByJobCodes(jobCodeIdList);
//        }
//
//        Status utCreatedStatus = dataService.getStatusByName(Constants.S_UT_CREATED);
//        List<UserTraining> userTrainings = new ArrayList<>();
//        String trainingCreatedMsg = "";
//        List<Map<String, Object>> applicableParties = new ArrayList<Map<String, Object>>();
//        for (Map<String, Object> party : applicablePartyList) {
//            Boolean isPartOfInduction = Boolean.FALSE;
//            if (statusName.equals(Constants.STATUS_TM_INPROGRESS)) {
//                if (isValidUserForInprogressSops(party)) {
//                    UserTraining newUt = prepareUserTrainingForCreation(trainingTm, party, utCreatedStatus, isPartOfInduction);
//                    userTrainings.add(newUt);
//
//                    trainingCreatedMsg = trainingCreatedMsg + "," + newUt.getId();
//                    applicableParties.add(party);
//                }
//            } else {
//                if (isValidUserForTraining(party)) {
//                    if (Constants.PARTY_JOB_CODE.equals(party.get("statusName"))) {
//                        isPartOfInduction = Boolean.TRUE;
//                    }
//                    UserTraining newUt = prepareUserTrainingForCreation(trainingTm, party, utCreatedStatus, isPartOfInduction);
//                    userTrainings.add(newUt);
//
//                    trainingCreatedMsg = trainingCreatedMsg + "," + newUt.getId();
//                    applicableParties.add(party);
//                }
//            }
//        }
//        utService.saveAll(userTrainings);

        Map<String, Object> respMap = new HashMap<String, Object>();
        respMap.put("trainingCreatedMsg", "trainingCreatedMsg");
        respMap.put("applicableParties", "applicableParties");
        return respMap;

    }

    public String convertToJSON(Object object) {
        return new Gson().toJson(object);
    }

    private LocalDate concertStringToLocalDate(String date) {
        LocalDate localDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN_FOR_LOCAL_DATE);
            localDate = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            System.out.println("Exception occured while parsing the date : " + e);
        }
        return localDate;
    }

    private String getpsNameById(Long departmnetId) {
        Map<String, Object> result = getPsDetailsById(departmnetId);
        return (String) result.get("name");
    }

    private Map<String, Object> getPsDetailsById(Long id) {
        ResponseEntity<Object> webClientResult = dataService.getProductStoreDetailsById(id);
        Map<String, Object> result =(Map<String, Object>)webClientResult.getBody();
        return result;
    }



}
