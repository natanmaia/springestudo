package br.com.natanmaia.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PessoaVO buscarPorId(@PathVariable("id") Long id) {
		PessoaVO vo = pessoaService.buscarPorId(id);
		vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(id)).withSelfRel());
		return vo;
	}

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PessoaVO> buscarTodos() {
		List<PessoaVO> vos = pessoaService.buscarTodos();
		vos.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(PessoaController.class).buscarPorId(p.getKey())).withSelfRel()
					)
				);
		return vos;

	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PessoaVO criar(@RequestBody PessoaVO pessoaVO) {
		PessoaVO vo = pessoaService.criar(pessoaVO);
		vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(vo.getKey())).withSelfRel());
		return vo;

	}

	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PessoaVO atualizar(@RequestBody PessoaVO pessoaVO) {
		PessoaVO vo = pessoaService.atualizar(pessoaVO);
		vo.add(linkTo(methodOn(PessoaController.class).buscarPorId(vo.getKey())).withSelfRel());
		return vo;

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		pessoaService.deletar(id);
		return ResponseEntity.ok().build();

	}
}
