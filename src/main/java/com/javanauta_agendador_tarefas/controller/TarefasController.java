package com.javanauta_agendador_tarefas.controller;


import com.javanauta_agendador_tarefas.businnes.TarefasService;
import com.javanauta_agendador_tarefas.businnes.dto.TarefasDTORecord;
import com.javanauta_agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.javanauta_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTORecord> gravarTarefas(@RequestBody TarefasDTORecord dto,
                                                    @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")

    public ResponseEntity<List<TarefasDTORecord>> buscaListaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));

    }

    @GetMapping
    public ResponseEntity<List<TarefasDTORecord>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmailUsuario(token));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaTarefasPorId(@RequestParam("id") String id) {

        tarefasService.deletaTarefaPorId(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefasDTORecord> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                              @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefasService.alteraStatusTarefa(status, id));

    }

    @PutMapping
    public ResponseEntity<TarefasDTORecord> updateTarefas(@RequestBody TarefasDTORecord dto, @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id));

    }


}




