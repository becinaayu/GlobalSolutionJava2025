package com.fiap.queimadas.controller;

import com.fiap.queimadas.model.Foco;
import com.fiap.queimadas.model.TipoFoco;
import com.fiap.queimadas.repository.SensorRepository;
import com.fiap.queimadas.service.FocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/focos")
public class FocoController {
    @Autowired
    private FocoService focoService;

    @Autowired
    private SensorRepository sensorRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("focos", focoService.listarTodos());
        return "foco/list";
    }

    @GetMapping("/novo")
    public String novoFoco(Model model) {
        model.addAttribute("foco", new Foco());
        model.addAttribute("sensores", sensorRepo.findAll());
        model.addAttribute("tipos", TipoFoco.values());
        return "foco/form";
    }

    @PostMapping("/salvar")
    public String salvarFoco(@ModelAttribute Foco foco, RedirectAttributes redirectAttributes) {
        try {
            focoService.salvar(foco);
            redirectAttributes.addFlashAttribute("mensagem", "Foco salvo com sucesso!");
            return "redirect:/focos";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar foco: " + e.getMessage());
            return "redirect:/focos/novo";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        try {
            Foco foco = focoService.buscarPorId(id).orElseThrow();
            model.addAttribute("foco", foco);
            model.addAttribute("sensores", sensorRepo.findAll());
            model.addAttribute("tipos", TipoFoco.values());
            return "foco/form";
        } catch (Exception e) {
            return "redirect:/focos";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            focoService.deletar(id);
            redirectAttributes.addFlashAttribute("mensagem", "Foco removido com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao remover foco!");
        }
        return "redirect:/focos";
    }
}