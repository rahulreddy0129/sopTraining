package com.sop.sopSample.repository;

import com.sop.sopSample.model.Tm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TmRepository extends JpaRepository<Tm, Long>, JpaSpecificationExecutor<Tm> {

}
