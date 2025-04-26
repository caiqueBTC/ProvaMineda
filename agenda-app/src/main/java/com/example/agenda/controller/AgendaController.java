package com.example.agenda.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.example.agenda.entity.Agenda;
import com.example.agenda.service.AgendaService;

@RestController
@RequestMapping("/agenda")
@CrossOrigin
public class AgendaController {

    @Autowired
    private AgendaService agendaService; 

   
    @PostMapping
    public ResponseEntity<Agenda> cadastrar(@RequestBody Agenda agenda) {
        Agenda agendaSalva = agendaService.cadastrar(agenda);
        return ResponseEntity.ok(agendaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> listarTodos() {
        List<Agenda> agendas = agendaService.listarTodos();
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Agenda>> buscarPorDataECompromisso(
            @RequestParam("dataHoraLimite") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraLimite,
            @RequestParam("compromisso") String compromisso) {


        List<Agenda> agendas = agendaService.buscarPorDataInicioAnteriorECompromisso(dataHoraLimite, compromisso);
        return ResponseEntity.ok(agendas);
    }
}