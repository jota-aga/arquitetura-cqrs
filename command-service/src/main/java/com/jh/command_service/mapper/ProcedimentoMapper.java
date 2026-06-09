package com.jh.command_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.jh.command_service.dto.ProcedimentoDTO;
import com.jh.command_service.entity.Procedimento;

@Mapper
public interface ProcedimentoMapper {

	ProcedimentoMapper INSTANCE = Mappers.getMapper(ProcedimentoMapper.class);
	
	Procedimento dtoToEntity(ProcedimentoDTO dto);
	
	Procedimento atualizar(@MappingTarget Procedimento procedimento, ProcedimentoDTO dto);
}
