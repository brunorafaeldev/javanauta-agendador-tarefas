package com.javanauta_agendador_tarefas.businnes.mapper;


import com.javanauta_agendador_tarefas.businnes.dto.TarefasDTO;
import com.javanauta_agendador_tarefas.infrastructure.entity.TarefasEntity;
import jdk.jfr.MemoryAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper (componentModel = "spring") // não deixa o código tão verboso como o .builder do lombok, precisa colocar as dependencias do mapper
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataCriacaoTarefa", target = "dataCriacaoTarefa")
    @Mapping(source = "dataEvento" , target = "dataEvento")
    TarefasEntity paraTarefaEntity (TarefasDTO dto);

    TarefasDTO paraTarefaDTO (TarefasEntity entity);

    List<TarefasEntity>  paraListaTarefaEntity (List<TarefasDTO> dtos);
    List<TarefasDTO> paraListaTarefaDTO (List<TarefasEntity> entities);





}
