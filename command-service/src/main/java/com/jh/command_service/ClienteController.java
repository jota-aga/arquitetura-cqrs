package com.jh.command_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO clienteDTO) {
		clienteService.criarCliente(clienteDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
		clienteService.atualizarCliente(id, clienteDTO);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirCliente(@PathVariable Long id){
		clienteService.excluirCliente(id);
		
		return ResponseEntity.noContent().build();
	}
}
