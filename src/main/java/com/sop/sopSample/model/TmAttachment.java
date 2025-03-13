package com.sop.sopSample.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class TmAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;
    private String attachmentName;
    private String description;
    private String attachmentType;
    private String extId;
    private String contentType;
    private boolean isPersisted;
    private Tm tm;

    private byte[] fileAttachment;
    private String fileAttachmentContentType;
    private String attachmentUrl;
    private String mimeType;
    private String attachment;

    public TmAttachment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isPersisted() {
        return isPersisted;
    }

    public void setPersisted(boolean persisted) {
        isPersisted = persisted;
    }

    public Tm getTm() {
        return tm;
    }

    public void setTm(Tm tm) {
        this.tm = tm;
    }

    public byte[] getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(byte[] fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    public String getFileAttachmentContentType(String contentType) {
        return fileAttachmentContentType;
    }

    public void setFileAttachmentContentType(String fileAttachmentContentType) {
        this.fileAttachmentContentType = fileAttachmentContentType;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public  String getTmAttachment() {
        return attachment;
    }

    @Override
    public String toString() {
        return "TmAttachment{" +
                "id=" + id +
                ", attachmentName='" + attachmentName + '\'' +
                ", description='" + description + '\'' +
                ", attachmentType='" + attachmentType + '\'' +
                ", extId='" + extId + '\'' +
                ", contentType='" + contentType + '\'' +
                ", isPersisted=" + isPersisted +
                ", tm=" + tm +
                ", fileAttachment=" + Arrays.toString(fileAttachment) +
                ", fileAttachmentContentType='" + fileAttachmentContentType + '\'' +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }


}
