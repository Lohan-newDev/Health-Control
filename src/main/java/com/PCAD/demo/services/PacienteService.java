package com.PCAD.demo.services;

import com.PCAD.demo.exceptions.pacienteException.PacienteJaCadastradoException;
import com.PCAD.demo.exceptions.pacienteException.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {


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
