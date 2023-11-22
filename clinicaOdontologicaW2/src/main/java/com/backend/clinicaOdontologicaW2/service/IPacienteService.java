package com.backend.clinicaOdontologicaW2.service;

import com.backend.clinicaOdontologicaW2.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.paciente.PacienteSalidaDto;

import java.util.List;

public interface IPacienteService {

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto pacienteEntradaDto);
    List<PacienteSalidaDto> listarPacientes();
    PacienteSalidaDto buscarPacientePorId(Long id);
    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto pacienteModificacionEntradaDto);
    void eliminarPaciente(Long id);
    PacienteSalidaDto buscarPacientePorDni(int dni);

}
