package com.fiap.queimadas.repository;

import com.fiap.queimadas.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
