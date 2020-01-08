package br.com.natanmaia.services;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<Pessoa> buscarTodos() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < 8; i++) {
			Pessoa pessoa = mockPessoa(i);
			pessoas.add(pessoa);
		}
		return pessoas;
	}

	private Pessoa mockPessoa(int i) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(counter.incrementAndGet());
		pessoa.setNome("Nome " + i);
		pessoa.setSobrenome("Sobrenome " + 1);
		pessoa.setEndereco("Endereço " + 1);
		pessoa.setGenero("Genero");
		return pessoa;
	}
}
