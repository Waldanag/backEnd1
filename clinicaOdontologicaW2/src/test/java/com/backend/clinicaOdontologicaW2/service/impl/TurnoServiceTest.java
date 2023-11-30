package com.backend.clinicaOdontologicaW2.service.impl;

import com.backend.clinicaOdontologicaW2.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologicaW2.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Test
    @Order(1)
    void deberiaLanzarExcepcionAlActualizarTurnoInexistente() {
        TurnoModificacionEntradaDto modificacionDto = new TurnoModificacionEntradaDto();
        modificacionDto.setId(999L);
        modificacionDto.setFechaYHora(LocalDateTime.now().plusDays(2));

        assertThrows(ResourceNotFoundException.class, () -> turnoService.actualizarTurno(modificacionDto));
    }

    @Test
    @Order(2)
    void deberiaLanzarExcepcionAlEliminarTurnoInexistente() {
        Long idInexistente = 999L;

        assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(idInexistente));
    }

    @Test
    @Order(3)
    void deberiaDevolverListaVaciaCuandoNoHayTurnos() {
        List<TurnoSalidaDto> turnosDto = turnoService.listarTurnos();

        assertTrue(turnosDto.isEmpty());
    }

}