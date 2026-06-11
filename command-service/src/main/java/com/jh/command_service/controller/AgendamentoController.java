package com.jh.command_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoDTO dto){
		agendamentoService.atualizarAgendamento(dto, id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarAgendamento(@PathVariable Long id){
		agendamentoService.deletarAgendamento(id);
		
		return ResponseEntity.noContent().build();
	}
}
