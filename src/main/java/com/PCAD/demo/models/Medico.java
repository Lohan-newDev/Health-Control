package com.PCAD.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "crm")
    private int crm;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayJob> dayJobs = new ArrayList<>();


    public Medico(UUID id, String name, int crm, DayJob dayJob) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.dayJobs = dayJobs;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public List<DayJob> getDayJobs() {
        return dayJobs;
    }

    public void setDayJobs(List<DayJob> dayJobs) {
        this.dayJobs = dayJobs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return crm == medico.crm && Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, crm);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crm=" + crm +
                '}';
    }
}