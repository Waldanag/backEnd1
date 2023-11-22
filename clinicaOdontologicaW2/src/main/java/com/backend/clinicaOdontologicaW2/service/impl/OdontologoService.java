package com.backend.clinicaOdontologicaW2.service.impl;

import com.backend.clinicaOdontologicaW2.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaW2.service.IOdontologoService;

import java.util.List;

public class OdontologoService implements IOdontologoService {
    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {
        return null;
    }

    @Override
    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologoEntradaDto) {
        return null;
    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarOdontologo(Long id) {

    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) {
        return null;
    }
}
