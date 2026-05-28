package com.codigo.EstebanAT.service;

import com.codigo.EstebanAT.dto.ReservaRequestDTO;
import com.codigo.EstebanAT.dto.ReservaResponseDTO;
import com.codigo.EstebanAT.mapper.ReservaMapper;
import com.codigo.EstebanAT.model.Reserva;
import com.codigo.EstebanAT.repository.ReservaRepository;
import com.codigo.EstebanAT.repository.SalaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;

    public ReservaService(
            ReservaRepository reservaRepository,
            SalaRepository salaRepository
    ) {

        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
    }

    public ReservaResponseDTO crear(ReservaRequestDTO dto) {

        if (salaRepository.findById(dto.salaId()) == null) {
            throw new RuntimeException("Sala no existe");
        }

        if (dto.horaFin().isBefore(dto.horaInicio())
                || dto.horaFin().equals(dto.horaInicio())) {

            throw new RuntimeException(
                    "Hora fin debe ser mayor a hora inicio"
            );
        }
        boolean existeCruce = reservaRepository.existeCruceHorario(
                dto.salaId(),
                dto.fecha(),
                dto.horaInicio(),
                dto.horaFin()
        );

        if (existeCruce) {
            throw new RuntimeException(
                    "La sala ya esta reservada en ese horario"
            );
        }
        Reserva reserva = ReservaMapper.toModel(null, dto);

        reserva.setEstado("PENDIENTE");

        reserva.setPasswordInterno("123456");

        Reserva guardada = reservaRepository.save(reserva);

        return ReservaMapper.toDTO(guardada);
    }

    public List<ReservaResponseDTO> listar() {

        return reservaRepository.findAll()
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public ReservaResponseDTO obtener(Long id) {

        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        return ReservaMapper.toDTO(reserva);
    }

    public List<ReservaResponseDTO> listarPorSala(Long salaId) {

        return reservaRepository.findBySalaId(salaId)
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public List<ReservaResponseDTO> listarPorEstado(String estado) {

        return reservaRepository.findByEstado(estado)
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public ReservaResponseDTO cambiarEstado(
            Long id,
            String estado
    ) {

        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        reserva.setEstado(estado);

        Reserva actualizada = reservaRepository.save(reserva);

        return ReservaMapper.toDTO(actualizada);
    }

    public String subirArchivo(
            Long id,
            MultipartFile file
    ) {

        Reserva reserva = reservaRepository.findById(id);

        if (reserva == null) {
            throw new RuntimeException("Reserva no encontrada");
        }

        return "Archivo recibido: "
                + file.getOriginalFilename();
    }

    public void eliminar(Long id) {

        reservaRepository.delete(id);
    }
}