package com.codigo.EstebanAT.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaRequestDTO(

        @NotNull(message = "SalaId es obligatorio")
        Long salaId,

        @NotBlank(message = "Responsable es obligatorio")
        String responsable,

        @Email(message = "Email invalido")
        @NotBlank(message = "Email obligatorio")
        String email,

        @FutureOrPresent(message = "La fecha no puede ser pasada")
        @NotNull(message = "Fecha obligatoria")
        LocalDate fecha,

        @NotNull(message = "Hora inicio obligatoria")
        LocalTime horaInicio,

        @NotNull(message = "Hora fin obligatoria")
        LocalTime horaFin

) {
}