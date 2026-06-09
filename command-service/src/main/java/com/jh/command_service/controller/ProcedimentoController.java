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

import com.jh.command_service.dto.ProcedimentoDTO;
import com.jh.command_service.service.ProcedimentoService;

@RequestMapping("/procedimento")
@RestController
public class ProcedimentoController {
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	
	@PostMapping
	public ResponseEntity<?> criarProcedimento(@RequestBody ProcedimentoDTO dto){
		procedimentoService.criarProcedimento(dto);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> deletarProcedimento(@PathVariable Long id, @RequestBody ProcedimentoDTO dto){
		procedimentoService.atualizarProcedimento(id, dto);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarProcedimento(@PathVariable Long id){
		procedimentoService.deletarProcedimento(id);
		
		return ResponseEntity.noContent().build();
	}
}
