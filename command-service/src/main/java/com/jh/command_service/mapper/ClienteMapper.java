package com.jh.command_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.jh.command_service.dto.ClienteDTO;
import com.jh.command_service.entity.Cliente;

@Mapper
public interface ClienteMapper {
	
	ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
	
	Cliente dtoToEntity(ClienteDTO dto);
	
	@Mapping(target = "createdAt", ignore = true)
	void atualizarCliente(@MappingTarget Cliente cliente, ClienteDTO dto);
}
