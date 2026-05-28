package com.codigo.EstebanAT.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SalaRequestDTO(

        @NotBlank(message = "El codigo es obligatorio")
        String codigo,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "La capacidad es obligatoria")
        @Positive(message = "La capacidad debe ser mayor a 0")
        Integer capacidad,

        @NotBlank(message = "La ubicacion es obligatoria")
        String ubicacion,

        Boolean activa

) {
}