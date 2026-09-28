package com.javanauta_agendador_tarefas.businnes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javanauta_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record TarefasDTORecord(String id,
                               String nomeTarefa,
                               String descricaoTarefa,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime dataCriacaoTarefa,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime dataEvento,
                               String emailUsuario,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime dataAlteracaoTarefa,
                               StatusNotificacaoEnum statusNotificacaoEnum) {
}





