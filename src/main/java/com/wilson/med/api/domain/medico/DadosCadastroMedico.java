package com.wilson.med.api.domain.medico;

import com.wilson.med.api.domain.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

		@NotBlank 
		String nome,

		@NotBlank
		// @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
		String telefone,

		@NotBlank @Email 
		String email,

		@Pattern(regexp = "\\d{4,6}") 
		String crm,

		@NotNull 
		Especialidade especialidade,

		@NotNull @Valid 
		DadosEndereco endereco) {

}
