package models;

import java.time.LocalDate;
import java.util.Objects;

public class Medico {

    private String Name;
    private int Crm;
    private LocalDate DiaDeAtendimento;


    public Medico(String name, int crm, LocalDate DiaDeAtendimento){
        this.Name = name;
        this.Crm = crm;
        this.DiaDeAtendimento = DiaDeAtendimento;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCrm() {
        return Crm;
    }

    public void setCrm(int crm) {
        this.Crm = crm;
    }

    public LocalDate getDiaDeAtendimento() {
        return DiaDeAtendimento;
    }

    public void setDiaDeAtendimento(LocalDate diaDeAtendimento) {
        this.DiaDeAtendimento = diaDeAtendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Crm == medico.Crm &&
                Objects.equals(Name, medico.Name) &&
                Objects.equals(DiaDeAtendimento, medico.DiaDeAtendimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Crm, DiaDeAtendimento);
    }
}
