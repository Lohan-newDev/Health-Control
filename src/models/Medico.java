package models;

import javax.xml.crypto.Data;

public class Medico {

    public String Nome;
    public int Crm;
    public Data DiaDeAtendimento;


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getCrm() {
        return Crm;
    }

    public void setCrm(int crm) {
        Crm = crm;
    }

    public Data getDiaDeAtendimento() {
        return DiaDeAtendimento;
    }

    public void setDiaDeAtendimento(Data diaDeAtendimento) {
        DiaDeAtendimento = diaDeAtendimento;
    }


}
