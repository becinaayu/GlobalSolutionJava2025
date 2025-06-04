package com.fiap.queimadas.service;

import com.fiap.queimadas.model.Sensor;
import com.fiap.queimadas.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> buscarPorId(Long id) {
        return sensorRepository.findById(id);
    }

    public Sensor salvar(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor atualizar(Long id, Sensor sensorAtualizado) {
        Optional<Sensor> sensorOptional = sensorRepository.findById(id);
        if (sensorOptional.isPresent()) {
            Sensor sensor = sensorOptional.get();
            sensor.setRegiao(sensorAtualizado.getRegiao());
            sensor.setAlertas(sensorAtualizado.getAlertas());
            sensor.setIdentificacao(sensorAtualizado.getIdentificacao());
            return sensorRepository.save(sensor);
        }
        return null;
    }

    public void deletar(Long id) {
        sensorRepository.deleteById(id);
    }
}
