package services;

import MedicoExceptions.MedicoJaCadastradoException;
import models.Medico;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class MedicoService {

    private List<Medico> ListaDeMedico = new ArrayList<>();


    public Medico CadastraMedico(Medico medico){
        for (Medico m : ListaDeMedico){
            if(m.getCrm() == medico.getCrm()){
                throw new MedicoJaCadastradoException(
                  "O medico de CRM ("+ medico.getCrm() + "ja está cadastrado em nosso sistema."
                );
            }
        }
        ListaDeMedico.add(medico);
        return medico;
    }
}
