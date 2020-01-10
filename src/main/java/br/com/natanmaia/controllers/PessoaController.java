package br.com.natanmaia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.natanmaia.models.Pessoa;
import br.com.natanmaia.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public Pessoa buscarPorId(@PathVariable("id") Long id) {
		return pessoaService.buscarPorId(id);
		
	}
	
	@GetMapping
	public List<Pessoa> buscarTodos() {
		return pessoaService.buscarTodos();
		
	}
	
	@PostMapping
	public Pessoa criar(@RequestBody Pessoa pessoa) {
		return pessoaService.criar(pessoa);
		
	}
	
	@PutMapping
	public Pessoa atualizar(@RequestBody Pessoa pessoa) {
		return pessoaService.criar(pessoa);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		pessoaService.deletar(id);
		return ResponseEntity.ok().build();
		
	}
}
