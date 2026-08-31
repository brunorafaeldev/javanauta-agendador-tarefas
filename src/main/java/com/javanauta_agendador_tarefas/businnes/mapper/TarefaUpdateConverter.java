package com.javanauta_agendador_tarefas.businnes.mapper;


import com.javanauta_agendador_tarefas.businnes.dto.TarefasDTO;
import com.javanauta_agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas (TarefasDTO dto, @MappingTarget TarefasEntity entity);

}
