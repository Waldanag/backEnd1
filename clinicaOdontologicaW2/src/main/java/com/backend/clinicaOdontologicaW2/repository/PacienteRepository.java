package com.backend.clinicaOdontologicaW2.repository;

import com.backend.clinicaOdontologicaW2.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByDni(int dni);

}
