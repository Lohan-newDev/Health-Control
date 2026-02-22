package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Consulta implements Serializable {
    private int crmMedico;
    private int rgPaciente;
    private LocalDateTime horarioDaConsulta;
    private static final long serialVersion = 1L;

    public Consulta(int crmMedico, int rgPaciente, LocalDateTime horarioDaConsulta) {
        this.crmMedico = crmMedico;
        this.rgPaciente = rgPaciente;
        this.horarioDaConsulta = horarioDaConsulta;
    }


    public int getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(int crmMedico) {
        this.crmMedico = crmMedico;
    }

    public int getRgPaciente() {
        return rgPaciente;
    }

    public void setRgPaciente(int rgPaciente) {
        this.rgPaciente = rgPaciente;
    }

    public LocalDateTime getHorarioDaConsulta() {
        return horarioDaConsulta;
    }

    public void setHorarioDaConsulta(LocalDateTime horarioDaConsulta) {
        this.horarioDaConsulta = horarioDaConsulta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return crmMedico == consulta.crmMedico && rgPaciente == consulta.rgPaciente && Objects.equals(horarioDaConsulta, consulta.horarioDaConsulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crmMedico, rgPaciente, horarioDaConsulta);
    }
}
