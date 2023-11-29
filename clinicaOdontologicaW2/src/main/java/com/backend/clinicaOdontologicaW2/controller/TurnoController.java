package com.backend.clinicaOdontologicaW2.controller;

import com.backend.clinicaOdontologicaW2.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologicaW2.exceptions.BadRequestException;
import com.backend.clinicaOdontologicaW2.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologicaW2.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService){
        this.turnoService = turnoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@RequestBody @Valid TurnoEntradaDto turno) throws BadRequestException {
        return new ResponseEntity<>(turnoService.registrarTurno(turno), HttpStatus.CREATED);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<TurnoSalidaDto> obtenerTurnoPorId(@PathVariable Long id){
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TurnoSalidaDto>> listarTurnos(){
        return new ResponseEntity<>(turnoService.listarTurnos(), HttpStatus.OK);
    }

    //PUT
    @PutMapping("/actualizar")
    public TurnoSalidaDto actualizarTurno(@RequestBody TurnoModificacionEntradaDto turno) throws ResourceNotFoundException {
        return turnoService.actualizarTurno(turno);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void EliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
    }
}
