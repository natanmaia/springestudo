package br.com.natanmaia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.natanmaia.models.Pessoa;
import br.com.natanmaia.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa buscarPorId(
			@PathVariable("id") String id) {
		
		return pessoaService.buscarPorId(id);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> buscarTodos() {
		
		return pessoaService.buscarTodos();
		
	}
}
