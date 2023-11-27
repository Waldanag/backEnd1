package com.backend.clinicaOdontologicaW2.dto.entrada.turno;

import com.backend.clinicaOdontologicaW2.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaW2.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaW2.entity.Odontologo;
import com.backend.clinicaOdontologicaW2.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoEntradaDto {

    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaYHora;
    @NotNull(message = "El campo Odontologo no puede ser nulo")
    @Valid
    private OdontologoSalidaDto odontologoSalidaDto;
    @NotNull(message = "El campo Paciente no puede ser nulo")
    @Valid
    private PacienteSalidaDto pacienteSalidaDto;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, OdontologoSalidaDto odontologoSalidaDto, PacienteSalidaDto pacienteSalidaDto) {
        this.fechaYHora = fechaYHora;
        this.odontologoSalidaDto = odontologoSalidaDto;
        this.pacienteSalidaDto = pacienteSalidaDto;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public OdontologoSalidaDto getOdontologoSalidaDto() {
        return odontologoSalidaDto;
    }

    public void setOdontologoSalidaDto(OdontologoSalidaDto odontologoSalidaDto) {
        this.odontologoSalidaDto = odontologoSalidaDto;
    }

    public PacienteSalidaDto getPacienteSalidaDto() {
        return pacienteSalidaDto;
    }

    public void setPacienteSalidaDto(PacienteSalidaDto pacienteSalidaDto) {
        this.pacienteSalidaDto = pacienteSalidaDto;
    }
}
