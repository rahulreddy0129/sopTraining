package com.sop.sopSample.repository;

import com.sop.sopSample.model.TrainingTm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingTmRepository extends JpaRepository<TrainingTm, Long>, JpaSpecificationExecutor {
}
