package com.codigo.EstebanAT.service;

import com.codigo.EstebanAT.dto.ReservaRequestDTO;
import com.codigo.EstebanAT.dto.ReservaResponseDTO;
import com.codigo.EstebanAT.mapper.ReservaMapper;
import com.codigo.EstebanAT.model.Reserva;
import com.codigo.EstebanAT.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public ReservaResponseDTO crear(ReservaRequestDTO dto) {

        Reserva reserva = ReservaMapper.toModel(null, dto);

        reserva.setEstado("PENDIENTE");

        reserva.setPasswordInterno("123456");

        Reserva guardada = reservaRepository.save(reserva);

        return ReservaMapper.toDTO(guardada);
    }

    public ReservaResponseDTO obtener(Long id) {

        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        return ReservaMapper.toDTO(reserva);
    }

    public List<ReservaResponseDTO> listar() {

        return reservaRepository.findAll()
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public void eliminar(Long id) {

        reservaRepository.delete(id);
    }
}