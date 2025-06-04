package com.fiap.queimadas.repository;

import com.fiap.queimadas.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
