package com.codigo.EstebanAT.mapper;

import com.codigo.EstebanAT.dto.SalaRequestDTO;
import com.codigo.EstebanAT.dto.SalaResponseDTO;
import com.codigo.EstebanAT.model.Sala;

public class SalaMapper {

    public static Sala toModel(Long id, SalaRequestDTO dto) {

        Sala sala = new Sala();

        sala.setId(id);
        sala.setCodigo(dto.codigo());
        sala.setNombre(dto.nombre());
        sala.setCapacidad(dto.capacidad());
        sala.setUbicacion(dto.ubicacion());

        sala.setActiva(
                dto.activa() != null ? dto.activa() : true
        );

        return sala;
    }

    public static SalaResponseDTO toDTO(Sala sala) {

        String descripcion = sala.getCodigo()
                + " - "
                + sala.getNombre()
                + " (cap. "
                + sala.getCapacidad()
                + ")";

        return new SalaResponseDTO(
                sala.getId(),
                sala.getCodigo(),
                sala.getNombre(),
                sala.getCapacidad(),
                sala.getUbicacion(),
                sala.isActiva(),
                descripcion
        );
    }
}