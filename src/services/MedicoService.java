package services;

import MedicoExceptions.MedicoJaCadastradoException;
import MedicoExceptions.MedicoNaoExisteException;
import Persistence.PercistenceService;
import models.Medico;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    private List<Medico> listaDeMedico = new ArrayList<>();
    PercistenceService medicoPercistence = new PercistenceService();

    public MedicoService (){
        listaDeMedico = medicoPercistence.carregarDado();
    }


    public void cadastrarMedico (String name, int crm, List<DayOfWeek> diaDeAtendimento){

        Medico novoMedico = new Medico (name, crm, diaDeAtendimento);

        for (Medico m : listaDeMedico) {
            if (m.getCrm() == crm) {
                throw new MedicoJaCadastradoException(
                        "O medico de CRM (" + crm + ")ja está cadastrado em nosso sistema."
                );
            }
        }
        listaDeMedico.add(novoMedico);
        medicoPercistence.salvarDado(listaDeMedico);
    }

    public List<Medico> verListaDeMedicos() {
        return listaDeMedico;
    }

    public List<Medico> procurarMedicoPorDiaDeAtendimento(DayOfWeek dia){

        List<Medico> medicos = new ArrayList<>();

        for(Medico m : listaDeMedico){
            if(m.getDiaDeAtendimento().contains(dia) ){
                medicos.add(m);
            }
        }

        return medicos;

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