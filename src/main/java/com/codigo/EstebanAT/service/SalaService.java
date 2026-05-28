package com.codigo.EstebanAT.service;

import com.codigo.EstebanAT.dto.SalaRequestDTO;
import com.codigo.EstebanAT.dto.SalaResponseDTO;
import com.codigo.EstebanAT.mapper.SalaMapper;
import com.codigo.EstebanAT.model.Sala;
import com.codigo.EstebanAT.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<SalaResponseDTO> listar() {

        return salaRepository.findAll()
                .stream()
                .map(SalaMapper::toDTO)
                .toList();
    }

    public SalaResponseDTO obtener(Long id) {

        Sala sala = salaRepository.findById(id);

        if (sala == null) {
            throw new RuntimeException("Sala no encontrada");
        }

        return SalaMapper.toDTO(sala);
    }

    public SalaResponseDTO crear(SalaRequestDTO dto) {

        Sala sala = SalaMapper.toModel(null, dto);

        if (dto.activa() == null) {
            sala.setActiva(true);
        }

        Sala guardada = salaRepository.save(sala);

        return SalaMapper.toDTO(guardada);
    }

    public SalaResponseDTO actualizar(Long id, SalaRequestDTO dto) {

        Sala sala = salaRepository.findById(id);

        if (sala == null) {
            throw new RuntimeException("Sala no encontrada");
        }

        sala.setCodigo(dto.codigo());
        sala.setNombre(dto.nombre());
        sala.setCapacidad(dto.capacidad());
        sala.setUbicacion(dto.ubicacion());

        if (dto.activa() != null) {
            sala.setActiva(dto.activa());
        }

        return SalaMapper.toDTO(sala);
    }

    public void eliminar(Long id) {

        salaRepository.delete(id);
    }
}