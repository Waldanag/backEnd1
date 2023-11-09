package com.backend.Clinica_OdontologicaW.service;

import com.backend.Clinica_OdontologicaW.model.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
    Paciente buscarPacientePorId(int id);
    Paciente actualizarPaciente(Paciente paciente);
}
