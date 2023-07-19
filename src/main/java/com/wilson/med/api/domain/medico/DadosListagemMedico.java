package com.wilson.med.api.domain.medico;

public record DadosListagemMedico(Long id, String nome, String telefone, String crm, String email,
		Especialidade especialidade) {

	public DadosListagemMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getCrm(), medico.getEmail(),
				medico.getEspecialidade());
	}

}
