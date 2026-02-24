package services;

import PacienteException.PacienteJaCadastradoException;
import PacienteException.PacienteNaoEncontradoException;
import Persistence.PercistenceService;
import models.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteService {

    private List<Paciente> listaDePacientes = new ArrayList<>();
    PercistenceService pacientePercistense = new PercistenceService();


    public void cadastraPaciente(String name, int idade, int rg, int healthInsurance, String phone){

        Paciente novoPaciente = new Paciente (name, idade, rg, healthInsurance, phone);

        for(Paciente p : listaDePacientes){
            if(p.getRg() == rg){
                throw new PacienteJaCadastradoException(
                        "Este Paciente ja está cadastrado"
                        );
            }
        }
        listaDePacientes.add(novoPaciente);
        pacientePercistense.salvarDado(listaDePacientes);
    }

    public List<Paciente> verListaDePacientesCadastrados(){
        return listaDePacientes;
    }

    public List<Paciente> procurarPacientesComPlanoDeSaude(int healthInsurance){

        List<Paciente> pacientes = new ArrayList<>();

        for(Paciente p : listaDePacientes){
            if (p.getHealthInsurance() == healthInsurance){
                pacientes.add(p);
            }
        }

        return pacientes;
    }

    public Paciente procurarPacientePorRg (int rg){

        for(Paciente p : listaDePacientes){
            if(p.getRg() == rg){
                return p;
            }
        }
        throw new PacienteNaoEncontradoException("Esse paciente não tem cadastro!");
    }

    public void apagarUmPaciente(int rg){
        for(Paciente p : listaDePacientes){
            if(p.getRg() == rg){
                listaDePacientes.remove(p);
                pacientePercistense.salvarDado(listaDePacientes);
            }
        }
    }
}
