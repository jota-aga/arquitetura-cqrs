package com.jh.command_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.command_service.dto.AgendamentoCreateDTO;
import com.jh.command_service.dto.AgendamentoUpdateDTO;
import com.jh.command_service.entity.Agendamento;
import com.jh.command_service.entity.Cliente;
import com.jh.command_service.entity.Procedimento;
import com.jh.command_service.mapper.AgendamentoMapper;
import com.jh.command_service.repository.AgendamentoRepository;
import com.jh.command_service.repository.ClienteRepository;
import com.jh.command_service.repository.ProcedimentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public void criarAgendamento(AgendamentoCreateDTO dto) {
		Agendamento agendamento = AgendamentoMapper.INSTANCE.dtoToEntity(dto);
		
		agendamentoRepository.save(agendamento);
	}
	
	public void atualizarAgendamento(AgendamentoCreateDTO dto, Long id) {
		Agendamento agendamento = procurarPorId(id);
		
		AgendamentoMapper.INSTANCE.atualizar(agendamento, dto);
		
		agendamentoRepository.save(agendamento);
	}
	
	@Transactional
	public void ocuparAgendamento(AgendamentoUpdateDTO dto, Long id) {
		Agendamento agendamento = procurarPorId(id);
		Cliente cliente = procurarClientePorId(dto.clienteId());
		Procedimento procedimento = procurarProcedimentoPorId(dto.procedimentoId());
		
		agendamento.setCliente(cliente);
		agendamento.setProcedimento(procedimento);
		agendamento.setDisponivel(false);
		
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
	
	private Cliente procurarClientePorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente por id não encontrado"));
	}
	
	private Procedimento procurarProcedimentoPorId(Long id) {
		return procedimentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Procedimento por id não encontrado"));
	}
}
