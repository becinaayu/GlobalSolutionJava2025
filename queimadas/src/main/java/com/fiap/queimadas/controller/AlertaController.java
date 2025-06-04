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
import com.fiap.queimadas.service.AlertaService;

@Controller
public class AlertaController {
    @Autowired
    private AlertaService alertaService;

    @GetMapping({"/alertas", "/alertas/dashboard", "/dashboard"})
    public String dashboard(Model model) {
        try {
            model.addAttribute("totalFocos", alertaService.contarTotalFocos());
            model.addAttribute("totalAgentes", alertaService.contarTotalAgentes());
            model.addAttribute("focosPorTipo", alertaService.contarFocosPorTipo());
            model.addAttribute("focosPorMes", alertaService.contarFocosPorMes());
        } catch (Exception e) {
            model.addAttribute("totalFocos", 0);
            model.addAttribute("totalAgentes", 0);
            model.addAttribute("focosPorTipo", new HashMap<>());
            model.addAttribute("focosPorMes", new HashMap<>());
        }
        return "dashboard/index";
    }
}