package br.com.natanmaia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.natanmaia.data.models.Pessoa;
import br.com.natanmaia.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	public Pessoa criar(Pessoa pessoa) {
		repository.save(pessoa);
		return pessoa;
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		Pessoa entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> 
				new ResourceNotFoundException("Sem resultados para esse ID!"));
		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		return repository.save(entity);
	}
	
	public void deletar(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Sem resultados para esse ID!"));
		repository.delete(entity);
	}

	public Pessoa buscarPorId(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sem resultados para esse ID!"));
	}
	
	public List<Pessoa> buscarTodos() {
		return repository.findAll();
	}

}
