package services;

import ConsultaExceptions.HorarioDeConsultaOcupadoException;
import MedicoExceptions.MedicoNaoExisteException;
import PacienteException.PacienteNaoEncontradoException;
import models.Consulta;
import models.Medico;
import models.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService {

    private List<Consulta> consultas = new ArrayList<>();

    private PacienteService pacienteService = new PacienteService();
    private MedicoService medicoService = new MedicoService();

    public void agendarUmaConsulta(int rgPaciente, int crmMedico, LocalDateTime horarioDaConsulta) {

        Paciente paciente = pacienteService.procurarPacientePorRg(rgPaciente);
        Medico medico = medicoService.procurarMedicoPorCrm(crmMedico);

        if(medico == null){
            throw new MedicoNaoExisteException("Medico não existente");
        }
        if(paciente == null){
            throw new PacienteNaoEncontradoException("Paciente não existente");
        }

        Consulta consulta = new Consulta(paciente.getRg(), medico.getCrm(), horarioDaConsulta);

        for (Consulta c : consultas) {
            if (c.getHorarioDaConsulta().equals(horarioDaConsulta) && c.getCrmMedico() == crmMedico ||
                    c.getHorarioDaConsulta().equals(horarioDaConsulta) && c.getCrmMedico() != crmMedico && c.getRgPaciente() == rgPaciente  ) {
                throw new HorarioDeConsultaOcupadoException("Este horario ja tem consulta!");
            }
        }
        consultas.add(consulta);
    }

}
