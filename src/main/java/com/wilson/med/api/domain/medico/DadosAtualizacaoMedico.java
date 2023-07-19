package com.wilson.med.api.domain.medico;

import com.wilson.med.api.domain.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

		@NotNull 
		Long id, 
		String nome, 
		String telefone, 
		DadosEndereco endereco) {

}
