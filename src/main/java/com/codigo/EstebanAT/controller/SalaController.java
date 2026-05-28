package com.codigo.EstebanAT.controller;

import com.codigo.EstebanAT.dto.SalaRequestDTO;
import com.codigo.EstebanAT.dto.SalaResponseDTO;
import com.codigo.EstebanAT.service.SalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<SalaResponseDTO> listar() {

        return salaService.listar();
    }

    @GetMapping("/{id}")
    public SalaResponseDTO obtener(@PathVariable Long id) {

        return salaService.obtener(id);
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> crear(
            @RequestBody SalaRequestDTO dto
    ) {

        SalaResponseDTO respuesta = salaService.crear(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(respuesta);
    }

    @PutMapping("/{id}")
    public SalaResponseDTO actualizar(
            @PathVariable Long id,
            @RequestBody SalaRequestDTO dto
    ) {

        return salaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ) {

        salaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}