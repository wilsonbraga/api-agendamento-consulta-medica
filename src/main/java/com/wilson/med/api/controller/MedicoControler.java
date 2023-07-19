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

import com.wilson.med.api.domain.medico.DadosAtualizacaoMedico;
import com.wilson.med.api.domain.medico.DadosCadastroMedico;
import com.wilson.med.api.domain.medico.DadosDetalhamentoMedico;
import com.wilson.med.api.domain.medico.DadosListagemMedico;
import com.wilson.med.api.domain.medico.Medico;
import com.wilson.med.api.domain.medico.MedicoRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("medicos")
public class MedicoControler {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	public ResponseEntity save(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
		var medico = new Medico(dados);
		medicoRepository.save(medico);
		
		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));

	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemMedico>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico:: new);
		return ResponseEntity.ok(page);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody @Valid DadosAtualizacaoMedico dados) {
		var medico  = medicoRepository.getReferenceById(dados.id());
		medico.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
	} 
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id){
		var medico = medicoRepository.getReferenceById(id);
		medico.exluir();
		return ResponseEntity.noContent().build();
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/{id}")
	public ResponseEntity listId(@PathVariable Long id){
		var medico = medicoRepository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
	}
	
}
