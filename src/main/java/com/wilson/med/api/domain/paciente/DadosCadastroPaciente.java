package com.wilson.med.api.domain.paciente;

import org.hibernate.validator.constraints.br.CPF;

import com.wilson.med.api.domain.endereco.DadosEndereco;
import com.wilson.med.api.domain.endereco.Endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
		
			@NotBlank
			String nome, 
			
			@NotBlank
			String telefone, 
			
			@NotBlank
			@Email
			String email, 
			
			@CPF
			String cpf, 
			
			@NotNull @Valid
			DadosEndereco endereco) {
		
	
	
}
