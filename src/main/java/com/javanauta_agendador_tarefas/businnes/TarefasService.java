package com.javanauta_agendador_tarefas.businnes;


import com.javanauta_agendador_tarefas.businnes.dto.TarefasDTORecord;
import com.javanauta_agendador_tarefas.businnes.mapper.TarefaUpdateConverter;
import com.javanauta_agendador_tarefas.businnes.mapper.TarefasConverter;
import com.javanauta_agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.javanauta_agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta_agendador_tarefas.infrastructure.repository.TarefasRepository;
import com.javanauta_agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefaRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;
    private final TarefaUpdateConverter tarefaUpdateConverter;

    public TarefasDTORecord gravarTarefas(String token, TarefasDTORecord dto) {

        String email = jwtUtil.extraiEmailToken(token.substring(7));
        TarefasDTORecord dtoFinal = new TarefasDTORecord(null, dto.nomeTarefa(),
                dto.descricaoTarefa(), LocalDateTime.now(), dto.dataEvento(), email, null, StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);
        return tarefasConverter.paraTarefaDTO(tarefaRepository.save(entity));


    }

    public List<TarefasDTORecord> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {

        return tarefasConverter.paraListaTarefaDTO
                (tarefaRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial,
                        dataFinal,
                        StatusNotificacaoEnum.PENDENTE));


    }

    public List<TarefasDTORecord> buscaTarefasPorEmailUsuario(String token) {
        String email = jwtUtil.extraiEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefaRepository.findByEmailUsuario(email);

        return tarefasConverter.paraListaTarefaDTO(listaTarefas);
    }

    public void deletaTarefaPorId(String id) {
        try {
            tarefaRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao deletar tarefa por id" + id, e.getCause());
        }
    }

    public TarefasDTORecord alteraStatusTarefa(StatusNotificacaoEnum status, String id) {
        try {

            TarefasEntity entity = tarefaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada" + id));
            entity.setStatusNotificacaoEnum(status);
            return tarefasConverter.paraTarefaDTO(tarefaRepository.save(entity));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("Erro ao alterar o status da tarefa" + id, e.getCause());
        }

    }

    public TarefasDTORecord updateTarefas(TarefasDTORecord dto, String id) {
        try {

            TarefasEntity entity = tarefaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada" + id));

            tarefaUpdateConverter.updateTarefas(dto, entity);
            return tarefasConverter.paraTarefaDTO(tarefaRepository.save(entity));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("Erro ao alterar o status da tarefa" + id, e.getCause());
        }


    }

}
