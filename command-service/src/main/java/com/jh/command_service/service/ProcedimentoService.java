package com.jh.command_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.command_service.dto.ProcedimentoDTO;
import com.jh.command_service.entity.Procedimento;
import com.jh.command_service.mapper.ProcedimentoMapper;
import com.jh.command_service.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {
	
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	public void criarProcedimento(ProcedimentoDTO dto) {
		Procedimento procedimento = ProcedimentoMapper.INSTANCE.dtoToEntity(dto);
		
		procedimentoRepository.save(procedimento);
	}
	
	public void atualizarProcedimento(Long id, ProcedimentoDTO dto) {
		Procedimento procedimento = procurarPorId(id);
		
		ProcedimentoMapper.INSTANCE.atualizar(procedimento, dto);
		
		procedimentoRepository.save(procedimento);
	}
	
	public void deletarProcedimento(Long id) {
		Procedimento procedimento = procurarPorId(id);
		
		procedimentoRepository.delete(procedimento);
	}
	
	private Procedimento procurarPorId(Long id) {
		return procedimentoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Procedimento por id não encontrado"));
	}
}
