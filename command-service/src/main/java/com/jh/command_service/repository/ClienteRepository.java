package com.jh.command_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jh.command_service.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
