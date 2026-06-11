package com.jh.command_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.command_service.dto.AgendamentoDTO;
import com.jh.command_service.service.AgendamentoService;

@RequestMapping("/agendamento")
@RestController
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@PostMapping
	public ResponseEntity<?> criarAgendamento(@RequestBody AgendamentoDTO dto){
		agendamentoService.criarAgendamento(dto);
		
		return ResponseEntity.noContent().build();
	}
}
