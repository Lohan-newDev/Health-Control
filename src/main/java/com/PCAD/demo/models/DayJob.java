package com.PCAD.demo.models;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class DayJob {

    @Id
    @GeneratedValue
    public long id;

    @Enumerated(EnumType.STRING)
    public DayOfWeek dayJob;

    public LocalTime timeStarts;
    public LocalTime timeends;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    public Medico medico;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DayOfWeek getDayJob() {
        return dayJob;
    }

    public void setDayJob(DayOfWeek dayJob) {
        this.dayJob = dayJob;
    }

    public LocalTime getTimeStarts() {
        return timeStarts;
    }

    public void setTimeStarts(LocalTime timeStarts) {
        this.timeStarts = timeStarts;
    }

    public LocalTime getTimeends() {
        return timeends;
    }

    public void setTimeends(LocalTime timeends) {
        this.timeends = timeends;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DayJob dayJob1 = (DayJob) o;
        return id == dayJob1.id && dayJob == dayJob1.dayJob && Objects.equals(timeStarts, dayJob1.timeStarts) && Objects.equals(timeends, dayJob1.timeends) && Objects.equals(medico, dayJob1.medico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayJob, timeStarts, timeends, medico);
    }

    @Override
    public String toString() {
        return "DayJob{" +
                "id=" + id +
                ", dayJob=" + dayJob +
                ", timeStarts=" + timeStarts +
                ", timeends=" + timeends +
                ", medico=" + medico +
                '}';
    }
}
