package com.fiap.queimadas.controller;

import com.fiap.queimadas.model.Regiao;
import com.fiap.queimadas.model.Sensor;
import com.fiap.queimadas.repository.RegiaoRepository;
import com.fiap.queimadas.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sensores")
public class SensorController {
    @Autowired
    private SensorRepository sensorRepo;

    @Autowired
    private RegiaoRepository regiaoRepo;

    // Listar todos os sensores
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("sensores", sensorRepo.findAll());
        return "sensor/list";
    }

    // Form de criação
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("sensor", new Sensor());
        // Para popular dropdown de regiões
        List<Regiao> regioes = regiaoRepo.findAll();
        model.addAttribute("regioes", regioes);
        return "sensor/form";
    }

    // Salvar
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Sensor sensor, @RequestParam("regiao_id") Long regiaoId) {
        Regiao regiao = regiaoRepo.findById(regiaoId).orElse(null);
        sensor.setRegiao(regiao);
        sensorRepo.save(sensor);
        return "redirect:/sensores";
    }

    // Form de edição
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Sensor sensor = sensorRepo.findById(id).orElseThrow();
        model.addAttribute("sensor", sensor);
        model.addAttribute("regioes", regiaoRepo.findAll());
        return "sensor/form";
    }

    // Deletar
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        sensorRepo.deleteById(id);
        return "redirect:/sensores";
    }
}
