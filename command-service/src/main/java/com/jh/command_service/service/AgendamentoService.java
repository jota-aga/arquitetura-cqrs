package com.jh.command_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.command_service.dto.AgendamentoDTO;
import com.jh.command_service.entity.Agendamento;
import com.jh.command_service.mapper.AgendamentoMapper;
import com.jh.command_service.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public void criarAgendamento(AgendamentoDTO dto) {
		Agendamento agendamento = AgendamentoMapper.INSTANCE.dtoToEntity(dto);
		
		agendamentoRepository.save(agendamento);
	}
	
	public void atualizarAgendamento(AgendamentoDTO dto, Long id) {
		Agendamento agendamento = procurarPorId(id);
		
		AgendamentoMapper.INSTANCE.atualizar(agendamento, dto);
		
		agendamentoRepository.save(agendamento);
	}
	
	public void deletarAgendamento(Long id) {
		Agendamento agendamento = procurarPorId(id);
		
		agendamentoRepository.delete(agendamento);
	}
	
	private Agendamento procurarPorId(Long id) {
		return agendamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agendamento por id não encontrado"));
	}
}
