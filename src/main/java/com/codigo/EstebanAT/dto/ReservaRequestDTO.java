package com.codigo.EstebanAT.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaRequestDTO(Long salaId, String responsable, String email,
                                LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){

}