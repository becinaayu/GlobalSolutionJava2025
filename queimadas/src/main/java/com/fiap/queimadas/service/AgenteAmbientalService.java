package com.fiap.queimadas.service;

import com.fiap.queimadas.model.AgenteAmbiental;
import com.fiap.queimadas.repository.AgenteAmbientalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteAmbientalService {
    @Autowired
    private AgenteAmbientalRepository agenteRepository;

    public List<AgenteAmbiental> listarTodos() {
        return agenteRepository.findAll();
    }

    public Optional<AgenteAmbiental> buscarPorId(Long id) {
        return agenteRepository.findById(id);
    }

    public AgenteAmbiental salvar(AgenteAmbiental agente) {
        return agenteRepository.save(agente);
    }

    public void deletar(Long id) {
        agenteRepository.deleteById(id);
    }
}