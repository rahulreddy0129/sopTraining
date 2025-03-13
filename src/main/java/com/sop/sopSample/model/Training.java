package com.sop.sopSample.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;
    private String name;
    private String description;
    private Integer sequenceNo;
    private String docRefNo;
    private Integer trainingHours;
    private Integer trainingMinutes;
    private Boolean requireExam;
    private Integer noOfQuestions;
    private Integer correctAnswersRequired;
    private Integer examQuestions;
    private String schedule;
    private String questions;
    private String jobcodes;
    private Instant fromDate;
    private Instant thruDate;
    private Instant startDate;
    private Instant endDate;
    private Boolean isExamOnline;
    private String remarks;
    private Long deptId;
    private String deptName;
    private Long qrCodeId;
    private String parent;
    private Boolean isPersisted;

    @ManyToOne(fetch = FetchType.LAZY)
    private TrainingCategory trainingCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private TrainingType trType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDocRefNo() {
        return docRefNo;
    }

    public void setDocRefNo(String docRefNo) {
        this.docRefNo = docRefNo;
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

    public Boolean getRequireExam() {
        return requireExam;
    }

    public void setRequireExam(Boolean requireExam) {
        this.requireExam = requireExam;
    }

    public Integer getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(Integer noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public Integer getCorrectAnswersRequired() {
        return correctAnswersRequired;
    }

    public void setCorrectAnswersRequired(Integer correctAnswersRequired) {
        this.correctAnswersRequired = correctAnswersRequired;
    }

    public Integer getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(Integer examQuestions) {
        this.examQuestions = examQuestions;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getJobcodes() {
        return jobcodes;
    }

    public void setJobcodes(String jobcodes) {
        this.jobcodes = jobcodes;
    }

    public Instant getFromDate() {
        return fromDate;
    }

    public void setFromDate(Instant fromDate) {
        this.fromDate = fromDate;
    }

    public Instant getThruDate() {
        return thruDate;
    }

    public void setThruDate(Instant thruDate) {
        this.thruDate = thruDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Boolean getExamOnline() {
        return isExamOnline;
    }

    public void setExamOnline(Boolean examOnline) {
        isExamOnline = examOnline;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(Long qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Boolean getPersisted() {
        return isPersisted;
    }

    public void setPersisted(Boolean persisted) {
        isPersisted = persisted;
    }

    public TrainingCategory getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(TrainingCategory trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    public TrainingType getTrType() {
        return trType;
    }

    public void setTrType(TrainingType trType) {
        this.trType = trType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", docRefNo='" + docRefNo + '\'' +
                ", trainingHours=" + trainingHours +
                ", trainingMinutes=" + trainingMinutes +
                ", requireExam=" + requireExam +
                ", noOfQuestions=" + noOfQuestions +
                ", correctAnswersRequired=" + correctAnswersRequired +
                ", examQuestions=" + examQuestions +
                ", schedule='" + schedule + '\'' +
                ", questions='" + questions + '\'' +
                ", jobcodes='" + jobcodes + '\'' +
                ", fromDate=" + fromDate +
                ", thruDate=" + thruDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isExamOnline=" + isExamOnline +
                ", remarks='" + remarks + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", qrCodeId=" + qrCodeId +
                ", parent='" + parent + '\'' +
                ", isPersisted=" + isPersisted +
                ", trainingCategory=" + trainingCategory +
                ", trType=" + trType +
                ", status=" + status +
                '}';
    }
}
