package com.fiap.queimadas.controller;

import com.fiap.queimadas.model.*;
import com.fiap.queimadas.repository.AgenteAmbientalRepository;
import com.fiap.queimadas.repository.AlertaRepository;
import com.fiap.queimadas.repository.FocoRepository;
import com.fiap.queimadas.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

@Controller
public class AlertaController {
    @Autowired
    private FocoRepository focoRepo;
    
    @Autowired
    private AgenteAmbientalRepository agenteRepo;

    @GetMapping({"/alertas", "/alertas/dashboard", "/dashboard"})
    public String dashboard(Model model) {
        try {
            // Contagem total de focos e agentes
            long totalFocos = focoRepo.count();
            long totalAgentes = agenteRepo.count();

            // Contagem de focos por tipo
            Map<TipoFoco, Long> focosPorTipo = focoRepo.findAll().stream()
                    .filter(f -> f.getTipo() != null)
                    .collect(Collectors.groupingBy(
                        Foco::getTipo, 
                        Collectors.counting()
                    ));

            // Focos por mês (últimos 6 meses)
            Map<String, Long> focosPorMes = focoRepo.findAll().stream()
                    .filter(f -> f.getDataHora() != null)
                    .filter(f -> f.getDataHora().isAfter(LocalDateTime.now().minusMonths(6)))
                    .collect(Collectors.groupingBy(
                            f -> f.getDataHora().format(DateTimeFormatter.ofPattern("MM/yyyy")),
                            Collectors.counting()
                    ));

            model.addAttribute("totalFocos", totalFocos);
            model.addAttribute("totalAgentes", totalAgentes);
            model.addAttribute("focosPorTipo", focosPorTipo);
            model.addAttribute("focosPorMes", focosPorMes);
            
        } catch (Exception e) {
            model.addAttribute("totalFocos", 0);
            model.addAttribute("totalAgentes", 0);
            model.addAttribute("focosPorTipo", new HashMap<>());
            model.addAttribute("focosPorMes", new HashMap<>());
        }
        
        return "dashboard/index";
    }
}