package com.codigo.EstebanAT.mapper;

import com.codigo.EstebanAT.dto.ReservaRequestDTO;
import com.codigo.EstebanAT.dto.ReservaResponseDTO;
import com.codigo.EstebanAT.model.Reserva;

public class ReservaMapper {

    public static Reserva toModel(Long id, ReservaRequestDTO dto) {

        Reserva reserva = new Reserva();

        reserva.setId(id);
        reserva.setSalaId(dto.salaId());
        reserva.setResponsable(dto.responsable());
        reserva.setEmail(dto.email());
        reserva.setFecha(dto.fecha());
        reserva.setHoraInicio(dto.horaInicio());
        reserva.setHoraFin(dto.horaFin());

        return reserva;
    }

    public static ReservaResponseDTO toDTO(Reserva reserva) {

        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getSalaId(),
                reserva.getResponsable(),
                reserva.getEmail(),
                reserva.getFecha(),
                reserva.getHoraInicio(),
                reserva.getHoraFin(),
                reserva.getEstado()
        );
    }
}