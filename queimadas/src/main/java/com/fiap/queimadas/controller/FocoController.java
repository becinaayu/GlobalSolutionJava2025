package com.fiap.queimadas.controller;

import com.fiap.queimadas.model.Foco;
import com.fiap.queimadas.model.Sensor;
import com.fiap.queimadas.model.TipoFoco;
import com.fiap.queimadas.repository.FocoRepository;
import com.fiap.queimadas.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/focos")
public class FocoController {
    @Autowired
    private FocoRepository focoRepo;

    @Autowired
    private SensorRepository sensorRepo;

    // Listar todos os focos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("focos", focoRepo.findAll());
        return "foco/list";
    }

    @GetMapping("/novo")
    public String novoFoco(Model model) {
        model.addAttribute("foco", new Foco());
        model.addAttribute("sensores", sensorRepo.findAll());
        model.addAttribute("tipos", TipoFoco.values());  // Adiciona os valores do enum
        return "foco/form"; // deve haver um arquivo foco/form.html
    }

@PostMapping("/salvar")
public String salvarFoco(@ModelAttribute Foco foco) {
    focoRepo.save(foco);
    return "redirect:/focos";
}


    // Form de edição
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Foco foco = focoRepo.findById(id).orElseThrow();
        model.addAttribute("foco", foco);
        model.addAttribute("sensores", sensorRepo.findAll());
        model.addAttribute("tipos", TipoFoco.values());  // Adiciona os valores do enum
        return "foco/form";
    }

    // Deletar
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        focoRepo.deleteById(id);
        return "redirect:/focos";
    }
}