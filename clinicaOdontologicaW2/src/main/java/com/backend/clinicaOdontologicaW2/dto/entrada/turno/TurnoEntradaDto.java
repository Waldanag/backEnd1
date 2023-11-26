package com.backend.clinicaOdontologicaW2.dto.entrada.turno;

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
    private Odontologo odontologo;
    @NotNull(message = "El campo Paciente no puede ser nulo")
    @Valid
    private Paciente paciente;

    public TurnoEntradaDto() {
    }
    public TurnoEntradaDto(LocalDateTime fechaYHora, Odontologo odontologo, Paciente paciente) {
        this.fechaYHora = fechaYHora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
