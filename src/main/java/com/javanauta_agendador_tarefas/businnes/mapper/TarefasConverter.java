package com.javanauta_agendador_tarefas.businnes.mapper;


import com.javanauta_agendador_tarefas.businnes.dto.TarefasDTO;
import com.javanauta_agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring") // não deixa o código tão verboso como o .builder do lombok, precisa colocar as dependencias do mapper
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity (TarefasDTO dto);

    TarefasDTO paraTarefaDTO (TarefasEntity entity);





}
