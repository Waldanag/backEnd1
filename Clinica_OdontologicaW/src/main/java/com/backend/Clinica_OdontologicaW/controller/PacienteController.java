package com.backend.Clinica_OdontologicaW.controller;


import com.backend.Clinica_OdontologicaW.model.Paciente;
import com.backend.Clinica_OdontologicaW.service.IPacienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private IPacienteService pacienteService;
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //POST
    @PostMapping("/registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    @PostMapping("/buscarId")
    public Paciente buscarPacientePorId(@RequestBody Paciente paciente){
        return pacienteService.buscarPacientePorId(paciente.getId());
    }

    //PUT
    @PutMapping("/actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(paciente);
    }

}
