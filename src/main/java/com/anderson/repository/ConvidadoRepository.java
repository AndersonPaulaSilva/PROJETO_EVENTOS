package com.anderson.repository;

import com.anderson.model.Convidado;
import com.anderson.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {
    List<Convidado> findByEvento(Evento evento);
}
