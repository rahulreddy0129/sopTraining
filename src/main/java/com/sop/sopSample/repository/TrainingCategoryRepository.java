package com.sop.sopSample.repository;

import com.sop.sopSample.model.TrainingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCategoryRepository extends JpaRepository<TrainingCategory, Long>, JpaSpecificationExecutor<TrainingCategory> {

    TrainingCategory findByName(String catgName);
}
