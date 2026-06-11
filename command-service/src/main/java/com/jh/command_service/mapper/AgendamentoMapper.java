package com.jh.command_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.jh.command_service.dto.AgendamentoDTO;
import com.jh.command_service.entity.Agendamento;

@Mapper
public interface AgendamentoMapper {
	
	AgendamentoMapper INSTANCE = Mappers.getMapper(AgendamentoMapper.class);
	
	Agendamento dtoToEntity(AgendamentoDTO dto);
	
	Agendamento atualizar(@MappingTarget Agendamento agendamento, AgendamentoDTO dto);
}
