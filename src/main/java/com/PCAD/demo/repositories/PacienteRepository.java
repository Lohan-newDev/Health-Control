package com.PCAD.demo.repositories;

import com.PCAD.demo.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

    @Query("SELECT p FROM pacientes p WHERE p.healthInsurance IS NOT NULL AND p.healthInsurance <> 0")
    List<Paciente> findByHealthInsuranceNotNull();

    Paciente findByPersonalId();
    List<Paciente> findByName(String name);
    List<Paciente> findByAge(int age);
}
