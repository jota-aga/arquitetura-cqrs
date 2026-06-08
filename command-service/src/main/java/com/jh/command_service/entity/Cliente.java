package com.jh.command_service.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Cliente extends BaseEntity{
	
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Column(nullable = false, length = 50)
	private String telefone;
	
	@Column(length = 100)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Agendamento> agendamentos;

}
