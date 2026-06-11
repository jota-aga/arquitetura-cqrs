package com.jh.command_service.dto;

import java.time.LocalDateTime;

public record AgendamentoDTO(LocalDateTime horario, Boolean disponivel, Long clienteId, Long procedimentoId) {

}
