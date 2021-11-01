package com.fiap.servicocliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.servicocliente.model.Atividade;
import com.fiap.servicocliente.repository.AtividadeRepository;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	private AtividadeRepository atividadeRepository;

	@PostMapping
	public ResponseEntity<Atividade> post(@RequestBody Atividade model) {

		Atividade atividade = atividadeRepository.save(model);

		return new ResponseEntity<Atividade>(atividade, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Atividade> getAll() {
		return atividadeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Atividade> getById(@PathVariable String id) {
		Optional<Atividade> atividadeResponse = atividadeRepository.findById(id);

		if (!atividadeResponse.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(atividadeResponse.get(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Atividade> put(@PathVariable String id, @RequestBody Atividade model) {

		Optional<Atividade> atividade = atividadeRepository.findById(id);

		if (!atividade.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		Atividade atividadeUpdated = atividadeRepository.save(model);

		return new ResponseEntity<>(atividadeUpdated, HttpStatus.OK);
	}

}
