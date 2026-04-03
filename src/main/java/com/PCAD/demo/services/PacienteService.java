package com.PCAD.demo.services;

import com.PCAD.demo.exceptions.pacienteException.PacienteJaCadastradoException;
import com.PCAD.demo.exceptions.pacienteException.PacienteNaoEncontradoException;
import com.PCAD.demo.models.Paciente;
import com.PCAD.demo.repositories.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    private PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    };

    public void cadastraPaciente(Paciente paciente){

        if(pacienteRepository.existsById(paciente.getId())) {
            throw new PacienteJaCadastradoException("Esse paciente ja existe!");
        }
        else{
            pacienteRepository.save(paciente);
        }

    }

    public List<Paciente> findPacientes(){
        return pacienteRepository.findAll();
    }

    public List<Paciente> findPacienteWithHealthInsurance(){

        return pacienteRepository.findByHealthInsuranceNotNull();

    }

    public List<Paciente> findPacientesByName(String name){

        return pacienteRepository.findByName(name);

    }

    public Paciente findPacienteByPersonalId (int personalId){


        return pacienteRepository.findByPersonalId();


    }

    public void apagarUmPaciente(UUID id){

        if(!pacienteRepository.existsById(id)){
            throw new PacienteNaoEncontradoException("Esse Paciente não existe");
        }

        pacienteRepository.deleteById(id);


    }


}
