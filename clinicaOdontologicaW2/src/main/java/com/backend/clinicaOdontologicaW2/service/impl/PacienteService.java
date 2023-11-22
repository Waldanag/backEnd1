package com.backend.clinicaOdontologicaW2.service.impl;

import com.backend.clinicaOdontologicaW2.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaW2.service.IPacienteService;

import java.util.List;

public class PacienteService implements IPacienteService {
    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto pacienteEntradaDto) {
        return null;
    }

    @Override
    public List<PacienteSalidaDto> listarPacientes() {
        return null;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        return null;
    }

    @Override
    public PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto pacienteModificacionEntradaDto) {
        return null;
    }

    @Override
    public void eliminarPaciente(Long id) {

    }

    @Override
    public PacienteSalidaDto buscarPacientePorDni(int dni) {
        return null;
    }
}
