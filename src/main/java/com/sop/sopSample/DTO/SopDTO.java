package com.sop.sopSample.DTO;

import java.util.List;

public class SopDTO {
    private Long id;
    private Long trainingId;
    private String name;
    private Integer trainingHours;
    private Integer trainingMinutes;
    private String sopNumber;
    private Integer sopVersion;
    private String plannedDate;
    private String effectiveDate;
    private String isExamRequired;
    private Long sopTmType;
    private Integer totalQuestions;
    private Integer requiredQuestionsCount;
    private Integer correctAnswersCount;
    private List<QuestionDTO> questionList;
    private List<Long> jobCodeIds;
    private Boolean isNew;
    private Long prevSop;
    public SopDTO() {
        super();
    }

    public SopDTO(
            Long id,
            Long trainingId,
            String name,
            Integer trainingHours,
            Integer trainingMinutes,
            String sopNumber,
            Integer sopVersion,
            String plannedDate,
            String effectiveDate,
            String isExamRequired,
            Integer totalQuestions,
            Integer requiredQuestionsCount,
            Integer correctAnswersCount,
            List<QuestionDTO> questionList,
            Long sopTmType,
            List<Long> jobCodeIds,
            Boolean isNew,
            Long prevSop
    ) {
        this.id = id;
        this.trainingId = trainingId;
        this.name = name;
        this.trainingHours = trainingHours;
        this.trainingMinutes = trainingMinutes;
        this.sopNumber = sopNumber;
        this.sopVersion = sopVersion;
        this.plannedDate = plannedDate;
        this.effectiveDate = effectiveDate;
        this.isExamRequired = isExamRequired;
        this.totalQuestions = totalQuestions;
        this.requiredQuestionsCount = requiredQuestionsCount;
        this.correctAnswersCount = correctAnswersCount;
        this.questionList = questionList;
        this.sopTmType = sopTmType;
        this.jobCodeIds = jobCodeIds;
        this.isNew = isNew;
        this.prevSop = prevSop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrainingHours() {
        return trainingHours;
    }

    public void setTrainingHours(Integer trainingHours) {
        this.trainingHours = trainingHours;
    }

    public Integer getTrainingMinutes() {
        return trainingMinutes;
    }

    public void setTrainingMinutes(Integer trainingMinutes) {
        this.trainingMinutes = trainingMinutes;
    }

    public String getSopNumber() {
        return sopNumber;
    }

    public void setSopNumber(String sopNumber) {
        this.sopNumber = sopNumber;
    }

    public Integer getSopVersion() {
        return sopVersion;
    }

    public void setSopVersion(Integer sopVersion) {
        this.sopVersion = sopVersion;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getIsExamRequired() {
        return isExamRequired;
    }

    public void setIsExamRequired(String isExamRequired) {
        this.isExamRequired = isExamRequired;
    }

    public Long getSopTmType() {
        return sopTmType;
    }

    public void setSopTmType(Long sopTmType) {
        this.sopTmType = sopTmType;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Integer getRequiredQuestionsCount() {
        return requiredQuestionsCount;
    }

    public void setRequiredQuestionsCount(Integer requiredQuestionsCount) {
        this.requiredQuestionsCount = requiredQuestionsCount;
    }

    public Integer getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(Integer correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }

    public List<QuestionDTO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDTO> questionList) {
        this.questionList = questionList;
    }

    public List<Long> getJobCodeIds() {
        return jobCodeIds;
    }

    public void setJobCodeIds(List<Long> jobCodeIds) {
        this.jobCodeIds = jobCodeIds;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Long getPrevSop() {
        return prevSop;
    }

    public void setPrevSop(Long prevSop) {
        this.prevSop = prevSop;
    }
}


class QuestionDTO {

    private int questionType;
    private String question;
    private List<OptionDTO> optionList;

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<OptionDTO> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionDTO> optionList) {
        this.optionList = optionList;
    }
}


class OptionDTO {

    private String option;
    private boolean isCorrect;
    private boolean userChoice;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isUserChoice() {
        return userChoice;
    }

    public void setUserChoice(boolean userChoice) {
        this.userChoice = userChoice;
    }
}
