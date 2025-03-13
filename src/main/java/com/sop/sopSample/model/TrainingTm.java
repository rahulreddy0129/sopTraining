package com.sop.sopSample.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TrainingTm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;
    private LocalDate fromDate;
    private LocalDate thruDate;
    private Boolean Persisted;
    private Training training;
    private Tm tm;

    public TrainingTm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public Boolean getPersisted() {
        return Persisted;
    }

    public void setPersisted(Boolean persisted) {
        Persisted = persisted;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Tm getTm() {
        return tm;
    }

    public void setTm(Tm tm) {
        this.tm = tm;
    }

    @Override
    public String toString() {
        return "TrainingTm{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", thruDate=" + thruDate +
                ", Persisted=" + Persisted +
                ", training=" + training +
                ", tm=" + tm +
                '}';
    }
}
