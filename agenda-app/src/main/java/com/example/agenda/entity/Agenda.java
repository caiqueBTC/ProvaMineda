package com.example.agenda.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "age_agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "age_id")
    private Long id;

    @Column(name = "age_compromisso", nullable = false, length = 50)
    private String compromisso;

    @Column(name = "age_data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "age_data_hora_fim")
    private LocalDateTime dataHoraFim;

    @Column(name = "age_antecedencia")
    private Integer antecedencia;

    public Agenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(String compromisso) {
        this.compromisso = compromisso;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Integer getAntecedencia() {
        return antecedencia;
    }

    public void setAntecedencia(Integer antecedencia) {
        this.antecedencia = antecedencia;
    }
}
