package com.codigo.EstebanAT.repository;

import com.codigo.EstebanAT.model.Sala;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SalaRepository {

    private final List<Sala> salas = new ArrayList<>();

    private final AtomicLong counter = new AtomicLong(1);

    public List<Sala> findAll() {
        return salas;
    }

    public Sala save(Sala sala) {

        if (sala.getId() == null) {

            sala.setId(counter.getAndIncrement());

            salas.add(sala);

        } else {

            salas.removeIf(s -> s.getId().equals(sala.getId()));

            salas.add(sala);
        }

        return sala;
    }

    public Sala findById(Long id) {

        return salas.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Long id) {

        salas.removeIf(s -> s.getId().equals(id));
    }
}