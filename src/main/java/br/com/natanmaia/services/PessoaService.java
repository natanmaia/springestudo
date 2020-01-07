package br.com.natanmaia.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.natanmaia.models.Pessoa;

@Service
public class PessoaService {
	
	private final AtomicLong counter = new AtomicLong();

	public Pessoa buscarPorId(String id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setNome("Natan");
		pessoa.setSobrenome("Maia");
		pessoa.setEndereco("Horizonte, Ceará");
		pessoa.setGenero("Masculino");
		return pessoa;
	}
}
