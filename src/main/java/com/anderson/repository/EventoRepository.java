package com.anderson.repository;

import com.anderson.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Anderson on 18/09/2019.
 */
public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findByCodigo(long codigo);
}
