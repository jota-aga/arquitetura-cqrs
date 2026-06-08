package com.jh.command_service.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Procedimento extends BaseEntity{
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(length = 500)
	private String descricao;
	
	@Column(nullable = false)
	private BigDecimal preco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Agendamento> agendamentos;
}	
