package com.backend.clinicaOdontologicaW2.service.impl;

import com.backend.clinicaOdontologicaW2.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaW2.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteDeNombreSofiaYRetornarElId(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Sofia", "Mansilla", 123456789, LocalDate.of(2024, 1, 1), new DomicilioEntradaDto("calle", 1234, "Localidad", "Provincia"));
        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);
        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Sofia", pacienteSalidaDto.getNombre());
    }

    @Test
    @Order(2)
    void alIntentarEliminarUnPacienteConId1YaEliminado_deberiaLanzarUnaResourceNotFoundException(){
        try{
            pacienteService.eliminarPaciente(1L);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));
    }

    @Test
    @Order(3)
    void alIntertarRegistrarUnPacienteConNombreMayorA50Caracteresa_deberiaLanzarUnaResourceNotFoundExcepction(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("SofiaSofiaSofiaSofiaSofiaSofiaSofiaSofia", "Mansilla", 123456789, LocalDate.of(2024, 1, 1), new DomicilioEntradaDto("calle", 1234, "Localidad", "Provincia"));
        try{
            pacienteService.registrarPaciente(pacienteEntradaDto);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}