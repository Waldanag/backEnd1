package com.backend.clinicaOdontologicaW2.service.impl;

import com.backend.clinicaOdontologicaW2.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaW2.entity.Paciente;
import com.backend.clinicaOdontologicaW2.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologicaW2.repository.PacienteRepository;
import com.backend.clinicaOdontologicaW2.service.IPacienteService;
import com.backend.clinicaOdontologicaW2.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService implements IPacienteService {
    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }
    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto pacienteEntradaDto) {
        LOGGER.info("PacienteEntradaDto: " + JsonPrinter.toString(pacienteEntradaDto));
        Paciente pacienteEntidad = modelMapper.map(pacienteEntradaDto, Paciente.class);
        Paciente pacienteAPersistir = pacienteRepository.save(pacienteEntidad);
        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteAPersistir, PacienteSalidaDto.class);
        LOGGER.info("PacienteSalidaDto: " + JsonPrinter.toString(pacienteSalidaDto));
        return pacienteSalidaDto;
    }

    @Override
    public List<PacienteSalidaDto> listarPacientes() {
        List<PacienteSalidaDto> pacientesSalidaDto = pacienteRepository.findAll()
                .stream()
                .map(paciente -> modelMapper.map(paciente, PacienteSalidaDto.class))
                .toList();
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Listado de todos los pacientes: {}", JsonPrinter.toString(pacientesSalidaDto));
        return pacientesSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        Paciente pacienteBuscado = pacienteRepository.findById(id).orElse(null);
        PacienteSalidaDto pacienteEncontrado = null;
        if (pacienteBuscado != null) {
            pacienteEncontrado = modelMapper.map(pacienteBuscado, PacienteSalidaDto.class);
            LOGGER.info("Paciente encontrado: {}", JsonPrinter.toString(pacienteEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");
        return pacienteEncontrado;
    }

    @Override
    public PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto pacienteModificacionEntradaDto) {
        Paciente pacienteRecibido = modelMapper.map(pacienteModificacionEntradaDto, Paciente.class);
        Paciente pacienteAActualizar = pacienteRepository.findById(pacienteRecibido.getId()).orElse(null);

        PacienteSalidaDto pacienteSalidaDto = null;
        if (pacienteAActualizar != null) {
            pacienteAActualizar = pacienteRecibido;
            pacienteRepository.save(pacienteAActualizar);
            pacienteSalidaDto = modelMapper.map(pacienteAActualizar, PacienteSalidaDto.class);
            LOGGER.warn("Paciente actualizado: {}", JsonPrinter.toString(pacienteSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el paciente porque no se encuentra en nuestra base de datos");

            //lanzar excepcion correspondiente
        }
        return pacienteSalidaDto;
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).orElse(null) != null){
            pacienteRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el paciente con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + id);
        }
    }

    /*@Override
    public PacienteSalidaDto buscarPacientePorDni(int dni) {
        return null;
    }*/

    private void configureMapping() {
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));
        modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilioSalidaDto));
        modelMapper.typeMap(PacienteModificacionEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteModificacionEntradaDto::getDomicilioModificacionEntradaDto, Paciente::setDomicilio));

    }
}
