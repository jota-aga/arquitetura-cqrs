package com.jh.command_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Agendamento extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(nullable = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Procedimento procedimento;
	
	@Column(nullable = false)
	private LocalDateTime horario;
	
	@Column(nullable = false)
	private boolean disponivel;
}
