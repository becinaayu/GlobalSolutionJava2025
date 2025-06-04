package com.fiap.queimadas.service;

import com.fiap.queimadas.model.Alerta;
import com.fiap.queimadas.model.Sensor;
import com.fiap.queimadas.repository.AlertaRepository;
import com.fiap.queimadas.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final SensorRepository sensorRepository;

    public AlertaService(AlertaRepository alertaRepository, SensorRepository sensorRepository) {
        this.alertaRepository = alertaRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        if (alerta.getSensor() != null && alerta.getSensor().getId() != null) {
            Sensor sensor = sensorRepository.findById(alerta.getSensor().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Sensor não encontrado"));
            alerta.setSensor(sensor);
        } else {
            throw new IllegalArgumentException("Sensor é obrigatório");
        }

        return alertaRepository.save(alerta);
    }

    public void deletar(Long id) {
        alertaRepository.deleteById(id);
    }
}