package com.jh.command_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.command_service.dto.ClienteDTO;
import com.jh.command_service.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public void createCliente(@RequestBody ClienteDTO clienteDTO) {
		clienteService.criarCliente(clienteDTO);
		
	}
}
