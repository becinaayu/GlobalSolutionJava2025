package com.fiap.queimadas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // exemplo: "Amazônia", "Cerrado", "Pantanal", etc.
    private String nome;

    // Relação 1:N com Sensor
    @OneToMany(mappedBy = "regiao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sensor> sensores = new ArrayList<>();

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Sensor> getSensores() { return sensores; }
    public void setSensores(List<Sensor> sensores) { this.sensores = sensores; }
}
