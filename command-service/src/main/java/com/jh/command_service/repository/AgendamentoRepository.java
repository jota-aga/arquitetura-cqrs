package com.jh.command_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jh.command_service.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
