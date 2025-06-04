package com.fiap.queimadas.controller;

import com.fiap.queimadas.model.AgenteAmbiental;
import com.fiap.queimadas.repository.AgenteAmbientalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agentes")
public class AgenteAmbientalController {
    @Autowired
    private AgenteAmbientalRepository agenteRepo;

    // Listar
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("agentes", agenteRepo.findAll());
        return "agenteambiental/list";
    }

    // Form criação
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("agente", new AgenteAmbiental());
        return "agenteambiental/form";
    }

    // Salvar
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute AgenteAmbiental agente) {
        agenteRepo.save(agente);
        return "redirect:/agentes";
    }

    // Form edição
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        AgenteAmbiental agente = agenteRepo.findById(id).orElseThrow();
        model.addAttribute("agente", agente);
        return "agenteambiental/form";
    }

    // Deletar
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        agenteRepo.deleteById(id);
        return "redirect:/agentes";
    }
}
