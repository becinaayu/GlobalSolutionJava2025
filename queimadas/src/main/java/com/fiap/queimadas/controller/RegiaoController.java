package com.fiap.queimadas.controller;

import com.fiap.queimadas.model.Regiao;
import com.fiap.queimadas.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/regioes")
public class RegiaoController {
    @Autowired
    private RegiaoRepository regiaoRepo;

    // Listar todas as regiões
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("regioes", regiaoRepo.findAll());
        return "regiao/list";
    }

    // Exibir form de criação
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("regiao", new Regiao());
        return "regiao/form";
    }

    // Salvar (criar ou atualizar)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Regiao regiao) {
        regiaoRepo.save(regiao);
        return "redirect:/regioes";
    }

    // Exibir form de edição
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Regiao regiao = regiaoRepo.findById(id).orElseThrow();
        model.addAttribute("regiao", regiao);
        return "regiao/form";
    }

    // Deletar
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        regiaoRepo.deleteById(id);
        return "redirect:/regioes";
    }
}
