package models;

import java.io.Serializable;
import java.util.Objects;

public class Paciente implements Serializable {

    private String name;
    private int idade;
    private int rg;
    private int healthInsurance;
    private String phone;
    private static final long serialVersionUID = 1L;

    public Paciente(String name,int idade, int rg, int healthInsurance, String phone){
        this.name = name;
        this.idade = idade;
        this.rg = rg;
        this.healthInsurance = healthInsurance;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(int healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return rg == paciente.rg && healthInsurance == paciente.healthInsurance && Objects.equals(name, paciente.name) && Objects.equals(phone, paciente.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rg, healthInsurance, phone);
    }
}
