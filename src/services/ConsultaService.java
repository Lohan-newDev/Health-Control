package services;

import ConsultaExceptions.HorarioDeConsultaOcupadoException;
import models.Consulta;
import models.Medico;
import models.Paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService {

    List<Consulta> consultas = new ArrayList<>();

    public void agendarUmaConsulta(int rgPaciente, int crmMedico, LocalDateTime horarioDaConsulta){

        PacienteService pacienteService = new PacienteService();
        Paciente paciente = pacienteService.procurarPacientePorRg(rgPaciente);

        MedicoService medicoService = new MedicoService();
        Medico medico = medicoService.procurarMedicoPorCrm(crmMedico);

        Consulta consulta = new Consulta(paciente.getRg(), medico.getCrm(), horarioDaConsulta);
        
        for(Consulta c : consultas){
            if(c.getHorarioDaConsulta() == horarioDaConsulta){
                throw new HorarioDeConsultaOcupadoException("Este horario ja tem consulta marcada");
            }
            else{
               consultas.add(consulta);
            }
        }

        consultas.add(consulta);


    }


}
