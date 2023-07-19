package com.wilson.med.api.domain.medico;

import com.wilson.med.api.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String telenome, String email, String crm,
		Especialidade especialidade, Endereco endereco) {

	public DadosDetalhamentoMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(),
				medico.getEspecialidade(), medico.getEndereco());
	}
}
