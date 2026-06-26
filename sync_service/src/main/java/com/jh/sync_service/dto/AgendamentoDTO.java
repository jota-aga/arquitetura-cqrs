package com.jh.sync_service.dto;

import java.time.LocalDateTime;

public record AgendamentoDTO(String id, LocalDateTime horario, Boolean disponivel, ClienteDTO cliente, ProcedimentoDTO procedimento) {

}
