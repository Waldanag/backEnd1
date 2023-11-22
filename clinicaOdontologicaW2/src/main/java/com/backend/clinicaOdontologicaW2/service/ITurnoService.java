package com.backend.clinicaOdontologicaW2.service;

import com.backend.clinicaOdontologicaW2.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.turno.TurnoSalidaDto;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto);
    List<TurnoSalidaDto> listarTurnos();
    TurnoSalidaDto buscarTurnoPorId(Long id);
    TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turnoModificacionEntradaDto);
    void eliminarTurno(Long id);

}
