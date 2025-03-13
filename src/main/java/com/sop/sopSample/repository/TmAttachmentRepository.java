package com.sop.sopSample.repository;

import com.sop.sopSample.model.TmAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmAttachmentRepository extends JpaRepository<TmAttachment, Long>, JpaSpecificationExecutor<TmAttachment> {
    List<TmAttachment> findByTmId(Long id);
}
