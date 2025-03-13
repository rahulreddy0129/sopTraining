package com.sop.sopSample.service;

import com.sop.sopSample.model.TrainingTm;
import com.sop.sopSample.repository.TrainingTmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingTmService {

    @Autowired
    private TrainingTmRepository trainingTmRepository;

    public TrainingTm save(TrainingTm trainingTm) {
        return trainingTmRepository.save(trainingTm);
    }
}
