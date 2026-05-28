package com.codigo.EstebanAT.controller;

import com.codigo.EstebanAT.dto.ReservaRequestDTO;
import com.codigo.EstebanAT.dto.ReservaResponseDTO;
import com.codigo.EstebanAT.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(
            @Valid @RequestBody ReservaRequestDTO dto
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        reservaService.crear(dto)
                );
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listar() {

        return ResponseEntity.ok(
                reservaService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtener(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                reservaService.obtener(id)
        );
    }

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<ReservaResponseDTO>> listarPorSala(
            @PathVariable Long salaId
    ) {

        return ResponseEntity.ok(
                reservaService.listarPorSala(salaId)
        );
    }

    @GetMapping("/estado")
    public ResponseEntity<List<ReservaResponseDTO>> listarPorEstado(
            @RequestParam String estado
    ) {

        return ResponseEntity.ok(
                reservaService.listarPorEstado(estado)
        );
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<ReservaResponseDTO> cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado
    ) {

        return ResponseEntity.ok(
                reservaService.cambiarEstado(id, estado)
        );
    }

    @PostMapping("/{id}/archivo")
    public ResponseEntity<String> subirArchivo(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file
    ) {

        return ResponseEntity.ok(
                reservaService.subirArchivo(id, file)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ) {

        reservaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}