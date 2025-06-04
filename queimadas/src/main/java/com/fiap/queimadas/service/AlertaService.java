package com.fiap.queimadas.service;

import com.fiap.queimadas.model.TipoFoco;
import com.fiap.queimadas.repository.AgenteAmbientalRepository;
import com.fiap.queimadas.repository.FocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlertaService {
    @Autowired
    private FocoRepository focoRepository;
    
    @Autowired
    private AgenteAmbientalRepository agenteRepository;

    public long contarTotalFocos() {
        return focoRepository.count();
    }

    public long contarTotalAgentes() {
        return agenteRepository.count();
    }

    public Map<TipoFoco, Long> contarFocosPorTipo() {
        return focoRepository.findAll().stream()
                .filter(f -> f.getTipo() != null)
                .collect(Collectors.groupingBy(
                    f -> f.getTipo(),
                    Collectors.counting()
                ));
    }

    public Map<String, Long> contarFocosPorMes() {
        return focoRepository.findAll().stream()
                .filter(f -> f.getDataHora() != null)
                .filter(f -> f.getDataHora().isAfter(LocalDateTime.now().minusMonths(6)))
                .collect(Collectors.groupingBy(
                        f -> f.getDataHora().format(DateTimeFormatter.ofPattern("MM/yyyy")),
                        Collectors.counting()
                ));
    }
}