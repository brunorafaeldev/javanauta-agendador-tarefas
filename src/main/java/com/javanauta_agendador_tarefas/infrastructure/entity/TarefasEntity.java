package com.javanauta_agendador_tarefas.infrastructure.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.javanauta_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("tarefa")
public class TarefasEntity {

    @Id
    private String id;
    private String nomeTarefa;
    private String descricaoTarefa;
    private LocalDateTime dataCriacaoTarefa;
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracaoTarefa;
    private StatusNotificacaoEnum statusNotificacaoEnum;



}
