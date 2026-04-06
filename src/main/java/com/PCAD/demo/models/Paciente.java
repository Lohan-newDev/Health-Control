package com.PCAD.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "personalId")
    private int personalId;

    @Column(name = "healthInsurance")
    private Integer healthInsurance;

    @Column(name = "phone")
    private String phone;


    public Paciente(UUID id, String name,int age, int personalId, Integer healthInsurance, String phone){
        this.id = id;
        this.name = name;
        this.age = age;
        this.personalId = personalId;
        this.healthInsurance = healthInsurance;
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public int getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(int healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return personalId == paciente.personalId && healthInsurance == paciente.healthInsurance && Objects.equals(name, paciente.name) && Objects.equals(phone, paciente.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, personalId, healthInsurance, phone);
    }
}
