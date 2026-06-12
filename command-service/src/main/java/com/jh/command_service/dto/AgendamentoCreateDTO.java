package com.jh.command_service.dto;

import java.time.LocalDateTime;

public record AgendamentoCreateDTO(LocalDateTime horario, Boolean disponivel) {

}
