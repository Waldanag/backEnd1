package com.backend.clinicaOdontologicaW2.service;

import com.backend.clinicaOdontologicaW2.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.odontologo.OdontologoSalidaDto;

import java.util.List;

public interface IOdontologoService {

    List<OdontologoSalidaDto> listarOdontologos();


    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologoEntradaDto);

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id);

    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto);

}
