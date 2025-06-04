package com.fiap.queimadas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AgenteAmbiental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ex: “João Silva”, “Corpo de Bombeiros XYZ”
    private String nome;

    private String telefone;

    // Relação 1:N com Alerta
    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertasRecebidos = new ArrayList<>();



    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public List<Alerta> getAlertasRecebidos() { return alertasRecebidos; }
    public void setAlertasRecebidos(List<Alerta> alertasRecebidos) { this.alertasRecebidos = alertasRecebidos; }

}
