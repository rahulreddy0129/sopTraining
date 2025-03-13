package com.sop.sopSample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainingType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;
    private String name;
    private String description;
    private Boolean requireExam;
    private Boolean trainingOnline;

    public TrainingType() {
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

    public Boolean getRequireExam() {
        return requireExam;
    }

    public void setRequireExam(Boolean requireExam) {
        this.requireExam = requireExam;
    }

    public Boolean getTrainingOnline() {
        return trainingOnline;
    }

    public void setTrainingOnline(Boolean trainingOnline) {
        this.trainingOnline = trainingOnline;
    }

    @Override
    public String toString() {
        return "TrainingType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", requireExam=" + requireExam +
                ", trainingOnline=" + trainingOnline +
                '}';
    }
}
