package com.sop.sopSample.repository;

import com.sop.sopSample.model.TmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TmTYpeRepository extends JpaRepository<TmType, Long>, JpaSpecificationExecutor<TmType> {
}
