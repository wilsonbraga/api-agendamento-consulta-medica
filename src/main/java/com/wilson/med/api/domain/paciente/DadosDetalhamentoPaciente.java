package com.wilson.med.api.domain.paciente;

import com.wilson.med.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente( Long id, String nome, String telefone, String email,
		String cpf, Endereco endereco) {
	
	
	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), 
				paciente.getTelefone(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
	}
}
