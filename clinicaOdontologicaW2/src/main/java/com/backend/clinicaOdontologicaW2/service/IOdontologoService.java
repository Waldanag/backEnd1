package com.backend.clinicaOdontologicaW2.service;

import com.backend.clinicaOdontologicaW2.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaW2.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    List<OdontologoSalidaDto> listarOdontologos();
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologoEntradaDto);
    OdontologoSalidaDto buscarOdontologoPorId(Long id);
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) throws ResourceNotFoundException;

}
