package com.fiap.queimadas.service;

import com.fiap.queimadas.model.Foco;
import com.fiap.queimadas.model.Sensor;
import com.fiap.queimadas.repository.FocoRepository;
import com.fiap.queimadas.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FocoService {
    @Autowired
    private FocoRepository focoRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public List<Foco> listarTodos() {
        return focoRepository.findAll();
    }

    public Optional<Foco> buscarPorId(Long id) {
        return focoRepository.findById(id);
    }

    public Foco salvar(Foco foco) {
        if (foco.getSensor() != null && foco.getSensor().getId() != null) {
            Sensor sensor = sensorRepository.findById(foco.getSensor().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Sensor não encontrado"));
            foco.setSensor(sensor);
        } else {
            throw new IllegalArgumentException("Sensor é obrigatório");
        }

        return focoRepository.save(foco);
    }

    public void deletar(Long id) {
        focoRepository.deleteById(id);
    }
}
