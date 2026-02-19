package models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Medico {

    private String name;
    private int crm;
    private List<DayOfWeek> diaDeAtendimento;


    public Medico(String name, int crm, List<DayOfWeek> DiaDeAtendimento) {
        this.name = name;
        this.crm = crm;
        this.diaDeAtendimento = DiaDeAtendimento;

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


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return crm == medico.crm && Objects.equals(name, medico.name) && Objects.equals(diaDeAtendimento, medico.diaDeAtendimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crm, diaDeAtendimento);
    }
}