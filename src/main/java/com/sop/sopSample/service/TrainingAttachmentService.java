package com.sop.sopSample.service;

import com.sop.sopSample.config.Constants;
import com.sop.sopSample.model.Tm;
import com.sop.sopSample.model.TmAttachment;
import com.sop.sopSample.repository.TmAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class TrainingAttachmentService {

    @Autowired
    private TmAttachmentRepository tmAttachmentRepository;

    public void createTmAttachment(Tm tm, MultipartFile file, Long id) {
        List<TmAttachment> tmList = tmAttachmentRepository.findByTmId(tm.getId());
        if(!tmList.isEmpty()) {
            tmAttachmentRepository.deleteAll(tmList);
        }

        String fileName =file.getOriginalFilename();
        if(fileName != null && fileName.length() > 255) {
            fileName = fileName.substring(0, 255);
        }

        TmAttachment  attachment = new TmAttachment();
        attachment.setMimeType(file.getContentType());
        attachment.setAttachmentName(fileName);

        try {
            attachment.setFileAttachment(file.getBytes());
            attachment.getFileAttachmentContentType(file.getContentType());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file content for attachment");
        }
        attachment = saveAttachment(attachment);

        // Create and save the TmAttachment
        TmAttachment tma = new TmAttachment();
        tma.setTm(tm);
        tma.setAttachment(String.valueOf(attachment));
        tma.setAttachmentName(fileName);
        tma.setContentType(Constants.CONTENT_TM_TYPE);

        tmAttachmentRepository.save(tma);
    }

    private TmAttachment saveAttachment(TmAttachment attachment) {
        return tmAttachmentRepository.save(attachment);
    }
}
