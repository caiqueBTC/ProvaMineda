package com.example.agenda.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.example.agenda.entity.Agenda;
import com.example.agenda.repository.AgendaRepository;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository; 


    public Agenda cadastrar(Agenda agenda) {
        if (agenda.getDataHoraInicio() == null) {
            agenda.setDataHoraInicio(LocalDateTime.now().plusDays(1));
        }

        if (agenda.getDataHoraFim() != null &&
            (agenda.getDataHoraFim().isBefore(agenda.getDataHoraInicio()) || agenda.getDataHoraFim().isEqual(agenda.getDataHoraInicio())) ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data/hora de fim deve ser posterior à data/hora de início.");
        }

        if (agenda.getCompromisso() == null || agenda.getCompromisso().isBlank()) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo compromisso é obrigatório.");
        }

        return agendaRepository.save(agenda);
    }

    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

 
    public List<Agenda> buscarPorDataInicioAnteriorECompromisso(LocalDateTime dataHoraLimite, String compromisso) {
         if (dataHoraLimite == null || compromisso == null || compromisso.isBlank()) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data/hora limite e compromisso são obrigatórios para a busca.");
         }
     
        return agendaRepository.findByDataHoraInicioLessThanAndCompromissoIgnoreCase(dataHoraLimite, compromisso);
    }
}