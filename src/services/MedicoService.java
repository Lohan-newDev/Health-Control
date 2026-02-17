package services;

import MedicoExceptions.MedicoJaCadastradoException;
import MedicoExceptions.MedicoNãoExisteException;
import models.Medico;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    private List<Medico> listaDeMedico = new ArrayList<>();




    public void cadastrarMedico (String name, int crm, LocalDate diaDeAtendimento){

        Medico novoMedico = new Medico (name, crm, diaDeAtendimento);

        for (Medico m : listaDeMedico) {
            if (m.getCrm() == crm) {
                throw new MedicoJaCadastradoException(
                        "O medico de CRM (" + crm + ")ja está cadastrado em nosso sistema."
                );
            }
        }
        listaDeMedico.add(novoMedico);
    }

    public List<Medico> verListaDeMedicos() {
        return listaDeMedico;
    }

    public void apagarUmMedico(int crm) {
        for (Medico m : listaDeMedico) {
            if (m.getCrm() == crm) {
                listaDeMedico.remove(m);
            }

        }
    }
}