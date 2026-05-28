package com.codigo.EstebanAT.repository;

import com.codigo.EstebanAT.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();

    private final AtomicLong counter = new AtomicLong(1);

    public List<Reserva> findAll() {
        return reservas;
    }

    public Reserva save(Reserva reserva) {

        if (reserva.getId() == null) {

            reserva.setId(counter.getAndIncrement());

            reservas.add(reserva);

        } else {

            reservas.removeIf(r -> r.getId().equals(reserva.getId()));

            reservas.add(reserva);
        }

        return reserva;
    }

    public Reserva findById(Long id) {

        return reservas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Long id) {

        reservas.removeIf(r -> r.getId().equals(id));
    }
}