package com.backend.clinicaOdontologicaW2.service.impl;

import com.backend.clinicaOdontologicaW2.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaW2.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(2)
    void deberiaRegistrarNuevoOdontologo() {
        OdontologoEntradaDto entradaDto = new OdontologoEntradaDto("1234L", "Alejandra", "Gavotti");

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(entradaDto);

        assertNotNull(odontologoSalidaDto);
        assertEquals("1234L", odontologoSalidaDto.getMatricula());
        assertEquals("Alejandra", odontologoSalidaDto.getNombre());
        assertEquals("Gavotti", odontologoSalidaDto.getApellido());
    }

    @Test
    @Order(1)
    void deberiaBuscarOdontologoPorIdExistente() throws ResourceNotFoundException {
        OdontologoEntradaDto entradaDto = new OdontologoEntradaDto("1234L", "Alejandra", "Gavotti");
        OdontologoSalidaDto odontologoSalidaDto1 = odontologoService.registrarOdontologo(entradaDto);

        Long idExistente = 1L;

        OdontologoSalidaDto odontologoSalidaDto2 = odontologoService.buscarOdontologoPorId(idExistente);

        assertNotNull(odontologoSalidaDto2);
        assertEquals(idExistente, odontologoSalidaDto2.getId());
    }

    /*@Test
    @Order(3)
    void deberiaDevolverListaVaciaCuandoNoHayOdontologos() {
        List<OdontologoSalidaDto> odontologosDto = odontologoService.listarOdontologos();

        assertTrue(odontologosDto.isEmpty());
    }*/

    @Test
    @Order(4)
    void deberiaLanzarExcepcionAlActualizarOdontologoInexistente() {
        OdontologoModificacionEntradaDto modificacionDto = new OdontologoModificacionEntradaDto();
        modificacionDto.setId(999L);

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.actualizarOdontologo(modificacionDto));
    }

}
