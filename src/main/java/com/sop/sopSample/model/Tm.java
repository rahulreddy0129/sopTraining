package com.sop.sopSample.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
public class Tm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;
    private String name;
    private Integer sequenceNo;
    private String description;
    private Integer trainingHours;
    private Integer trainingMinutes;
    private Boolean requireExam;
    private Integer noOfQuestions;
    private Integer correctAnswersRequired;
    private Integer examQuestions;
    private String questions;
    private String jobcodes;
    private String info;
    private String attachmnetUrl;
    private Boolean isSop;
    private String sopNumber;
    private String sopVersion;
    private LocalDate effectiveDate;
    private LocalDate plannedDate;
    private LocalDate thruDate;
    private Long deptId;
    private String deptName;
    private String legacy;
    private Boolean isPersisted;
    private Long prevSop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_category_id")
    private TrainingCategory trainingCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tm_type_id")
    private TmType tmType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_type_id")
    private TrainingType trType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;


    public Tm() {
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

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSopNumber() {
        return sopNumber;
    }

    public void setSopNumber(String sopNumber) {
        this.sopNumber = sopNumber;
    }

    public Long getPrevSop() {
        return prevSop;
    }

    public void setPrevSop(Long prevSop) {
        this.prevSop = prevSop;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAttachmnetUrl() {
        return attachmnetUrl;
    }

    public void setAttachmnetUrl(String attachmnetUrl) {
        this.attachmnetUrl = attachmnetUrl;
    }

    public Boolean getSop() {
        return isSop;
    }

    public void setSop(Boolean sop) {
        isSop = sop;
    }

    public String getSopVersion() {
        return sopVersion;
    }

    public void setSopVersion(String sopVersion) {
        this.sopVersion = sopVersion;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
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

    public String getLegacy() {
        return legacy;
    }

    public void setLegacy(String legacy) {
        this.legacy = legacy;
    }

    public Boolean getPersisted() {
        return isPersisted;
    }

    public void setPersisted(Boolean persisted) {
        isPersisted = persisted;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public TrainingCategory getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(TrainingCategory trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    public TmType getTmType() {
        return tmType;
    }

    public void setTmType(TmType tmType) {
        this.tmType = tmType;
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
        return "Tm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", description='" + description + '\'' +
                ", trainingHours=" + trainingHours +
                ", trainingMinutes=" + trainingMinutes +
                ", requireExam=" + requireExam +
                ", noOfQuestions=" + noOfQuestions +
                ", correctAnswersRequired=" + correctAnswersRequired +
                ", examQuestions=" + examQuestions +
                ", questions='" + questions + '\'' +
                ", jobcodes='" + jobcodes + '\'' +
                ", info='" + info + '\'' +
                ", attachmnetUrl='" + attachmnetUrl + '\'' +
                ", isSop=" + isSop +
                ", sopNumber='" + sopNumber + '\'' +
                ", sopVersion='" + sopVersion + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", plannedDate=" + plannedDate +
                ", prevSop=" + prevSop +
                ", thruDate=" + thruDate +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", legacy='" + legacy + '\'' +
                ", isPersisted=" + isPersisted +
                ", training=" + training +
                ", trainingCategory=" + trainingCategory +
                ", tmType=" + tmType +
                ", trType=" + trType +
                ", status=" + status +
                '}';
    }
}
