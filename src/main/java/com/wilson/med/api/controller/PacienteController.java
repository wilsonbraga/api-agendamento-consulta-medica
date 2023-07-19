package com.wilson.med.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wilson.med.api.domain.paciente.DadosAtualizacaoPaciente;
import com.wilson.med.api.domain.paciente.DadosCadastroPaciente;
import com.wilson.med.api.domain.paciente.DadosDetalhamentoPaciente;
import com.wilson.med.api.domain.paciente.DadosListagemPaciente;
import com.wilson.med.api.domain.paciente.Paciente;
import com.wilson.med.api.domain.paciente.PacienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	public ResponseEntity save(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
		var paciente = new Paciente(dados);
		pacienteRepository.save(paciente);
		 
		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
		 
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> update(@RequestBody @Valid DadosAtualizacaoPaciente dados){
		var paciente = pacienteRepository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemPaciente>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = pacienteRepository.findAll(paginacao).map(DadosListagemPaciente:: new);
		return ResponseEntity.ok(page);
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		pacienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> LitId(@PathVariable Long id){
		var paciente = pacienteRepository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	
}
