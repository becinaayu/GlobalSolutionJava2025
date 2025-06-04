package com.fiap.queimadas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ex: “SATELITAL-01”, “ESTAÇÃO-XYZ”
    private String identificacao;

    // Relação N:1 com Região
    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

    // Relação 1:N com Alerta
    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas = new ArrayList<>();

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIdentificacao() { return identificacao; }
    public void setIdentificacao(String identificacao) { this.identificacao = identificacao; }

    public Regiao getRegiao() { return regiao; }
    public void setRegiao(Regiao regiao) { this.regiao = regiao; }

    public List<Alerta> getAlertas() { return alertas; }
    public void setAlertas(List<Alerta> alertas) { this.alertas = alertas; }
}
