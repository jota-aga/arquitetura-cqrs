package com.jh.command_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.command_service.dto.ClienteDTO;
import com.jh.command_service.entity.Cliente;
import com.jh.command_service.mapper.ClienteMapper;
import com.jh.command_service.repository.ClienteRepository;

@Service	
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void criarCliente(ClienteDTO dto) {
		Cliente cliente = ClienteMapper.INSTANCE.dtoToEntity(dto);
		
		clienteRepository.save(cliente);
	}
}
