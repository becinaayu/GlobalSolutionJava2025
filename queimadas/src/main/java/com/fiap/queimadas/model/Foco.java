package com.fiap.queimadas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Foco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    
    @Enumerated(EnumType.STRING)
    private TipoFoco tipo;
    
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    // Atualize os getters e setters para usar TipoFoco
    public TipoFoco getTipo() { return tipo; }
    public void setTipo(TipoFoco tipo) { this.tipo = tipo; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}