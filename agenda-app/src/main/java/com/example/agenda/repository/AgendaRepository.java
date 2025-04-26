package com.example.agenda.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.agenda.entity.Agenda;

@Repository

public interface AgendaRepository extends JpaRepository<Agenda, Long> {


    List<Agenda> findByDataHoraInicioLessThanAndCompromissoIgnoreCase(LocalDateTime dataHoraLimite, String compromisso);

}