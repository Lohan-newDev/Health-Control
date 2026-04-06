package com.PCAD.demo.repositories;

import com.PCAD.demo.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {

    @Query("SELECT m FROM medicos m WHERE m.dayJobs IS NOT NULL")
    List<Medico> findByDayJobs();
}
