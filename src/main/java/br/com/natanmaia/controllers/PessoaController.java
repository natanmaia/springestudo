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

import br.com.natanmaia.data.vo.PessoaVO;
import br.com.natanmaia.services.PessoaService;

@RestController
@RequestMapping("/api/pessoa/v1")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO buscarPorId(@PathVariable("id") Long id) {
		return pessoaService.buscarPorId(id);
		
	}
	
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PessoaVO> buscarTodos() {
		return pessoaService.buscarTodos();
		
	}
	
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO criar(@RequestBody PessoaVO pessoaVO) {
		return pessoaService.criar(pessoaVO);
		
	}
	
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PessoaVO atualizar(@RequestBody PessoaVO pessoaVO) {
		return pessoaService.atualizar(pessoaVO);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		pessoaService.deletar(id);
		return ResponseEntity.ok().build();
		
	}
}
