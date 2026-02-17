package services;

import PacienteException.PacienteJaCadastradoException;
import models.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteService {

    private List<Paciente> listaDePacientes = new ArrayList<>();


    public void cadastraPaciente(String name, int rg, int healthInsurance, String phone){

        Paciente novoPaciente = new Paciente (name, rg, healthInsurance, phone);

        for(Paciente p : listaDePacientes){
            if(p.getRg() == rg){
                throw new PacienteJaCadastradoException(
                        "Este Paciente ja está cadastrado"
                        );
            }
        }
        listaDePacientes.add(novoPaciente);
    }

    public List<Paciente> verListaDePacientesCadastrados(){
        return listaDePacientes;
    }

    public void apagarUmPaciente(int rg){
        for(Paciente p : listaDePacientes){
            if(p.getRg() == rg){
                listaDePacientes.remove(p);
            }
        }
    }
}
