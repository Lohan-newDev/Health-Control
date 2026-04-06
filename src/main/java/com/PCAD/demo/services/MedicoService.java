package com.PCAD.demo.services;

import com.PCAD.demo.exceptions.medicoExceptions.MedicoJaCadastradoException;
import com.PCAD.demo.exceptions.medicoExceptions.MedicoNaoExisteException;
import com.PCAD.demo.models.Medico;
import com.PCAD.demo.repositories.MedicoRepository;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService (MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }




    public void cadastrarMedico (Medico medico){

        if(medicoRepository.existsById(medico.getId())){
            throw new MedicoJaCadastradoException("Este medico ja Existe");
        }else {
            medicoRepository.save(medico);
        }
    }

    public List<Medico> procurarMedicosPorDiaDeAtendimento(DayOfWeek day){


        return medicoRepository.findByDayJobs();
    }
//        List<Medico> medicos = new ArrayList<>();
//
//        for(Medico m : listaDeMedico){
//            if(m.getDiaDeAtendimento().contains(dia) ){
//                medicos.add(m);
//            }
//        }
//
//        return medicos;



    public List<Medico> verListaDeMedicos() {
        return medicoRepository.findAll();
    }

    public Medico procurarMedicoPorCrm(int crm){

        for( Medico m : listaDeMedico){
            if(m.getCrm() == crm){
                return m;
            }
        }
        throw new MedicoNaoExisteException("Medico com esse crm não está cadastrado!");

    }

    public void apagarUmMedico(int crm) {
        for (Medico m : listaDeMedico) {
            if (m.getCrm() == crm) {
                listaDeMedico.remove(m);
            }

        }
        medicoPercistence.salvarDado(listaDeMedico);
    }
}