package com.wilson.med.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

		@NotBlank 
		String logradouro,

		@NotBlank(message = "bairro não deve está em branco.") 
		String bairro,

		@NotBlank 
		@Pattern(regexp = "\\d{8}") 
		String cep,

		@NotBlank 
		String cidade,

		@NotBlank 
		String uf,

		@NotBlank 
		String numero,

		String 
		complemento) {

}
