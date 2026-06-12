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

import com.jh.command_service.dto.AgendamentoCreateDTO;
import com.jh.command_service.dto.AgendamentoUpdateDTO;
import com.jh.command_service.service.AgendamentoService;

@RequestMapping("/agendamento")
@RestController
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@PostMapping
	public ResponseEntity<?> criarAgendamento(@RequestBody AgendamentoCreateDTO dto){
		agendamentoService.criarAgendamento(dto);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoCreateDTO dto){
		agendamentoService.atualizarAgendamento(dto, id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/agendar/{id}")
	public ResponseEntity<?> ocuparAgendamento(@PathVariable Long id, @RequestBody AgendamentoUpdateDTO dto){
		agendamentoService.ocuparAgendamento(dto, id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarAgendamento(@PathVariable Long id){
		agendamentoService.deletarAgendamento(id);
		
		return ResponseEntity.noContent().build();
	}
}
