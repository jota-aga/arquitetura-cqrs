package com.jh.sync_service.dto;

import java.math.BigDecimal;

public record ProcedimentoDTO(Long id, String nome, String descricao, BigDecimal preco) {

}
