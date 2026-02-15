package models;

public class Paciente {

    public String Name;
    public double Rg;
    public boolean HealthInsurance;
    public double Phone;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRg() {
        return Rg;
    }

    public void setRg(double rg) {
        Rg = rg;
    }

    public boolean isHealthInsurance() {
        return HealthInsurance;
    }

    public void setHealthInsurance(boolean healthInsurance) {
        HealthInsurance = healthInsurance;
    }

    public double getPhone() {
        return Phone;
    }

    public void setPhone(double phone) {
        Phone = phone;
    }
}
