package com.fiap.queimadas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data e hora em que o alerta foi gerado
    private LocalDateTime dataHora;

    // Mensagem ou nível de prioridade do alerta
    private String mensagem;

    // Relação N:1 com Sensor
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    // Relação N:1 com AgenteAmbiental (quem recebeu/foi notificado)
    @ManyToOne
    @JoinColumn(name = "agente_id")
    private AgenteAmbiental agente;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }

    public AgenteAmbiental getAgente() { return agente; }
    public void setAgente(AgenteAmbiental agente) { this.agente = agente; }

}
