package com.sop.sopSample.service;

import com.sop.sopSample.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private SopDataService dataService;

    public List<Training> getTrainingcategoryNameAndDepartment(String catgName, Long deptId) {
        return getTrainingcategoryNameAndDepartment(dataService.getTrainingCategoryByName(catgName).getName(), deptId);
    }

    public Training createTraining(String deptName, String tcRoleBased, String deptName1, Long departmnetId, Boolean aTrue, Boolean aTrue1) {
        Training training = new Training();

//        training.setName(deptName);
//        training.setDescription(description);
//        training.setCategory(dataService.getTrainingCategoryByName(categoryName));
//        training.setDeptId(departmentId);
//        training.setRequireExam(requireExam);
//        training.setIsExamOnline(isOnline);
//        training.setStatus(dataService.getStatusByName(Constants.S_T_CREATED));
//        return save(training);
        return training;
    }
}
