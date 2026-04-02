package models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

    @UUID
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "crm")
    private int crm;

    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> diaDeAtendimento;

    private LocalTime horaInicio;
    private LocalTime horaFim;


    public Medico(String name, int crm) {
        this.name = name;
        this.crm = crm;
//        this.diaDeAtendimento = DiaDeAtendimento;

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

    public List<DayOfWeek> getDiaDeAtendimento() {
        return diaDeAtendimento;
    }

    public void setDiaDeAtendimento(List<DayOfWeek> diaDeAtendimento) {
        this.diaDeAtendimento = diaDeAtendimento;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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