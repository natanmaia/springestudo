package br.com.natanmaia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.natanmaia.converter.DozerConverter;
import br.com.natanmaia.data.models.Pessoa;
import br.com.natanmaia.data.vo.PessoaVO;
import br.com.natanmaia.repository.PessoaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public PessoaVO criar(PessoaVO pessoa) {
        var entity = DozerConverter.parseObject(pessoa, Pessoa.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
        return vo;
    }

    public PessoaVO atualizar(PessoaVO pessoa) {
        var entity = repository.findById(pessoa.getKey())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sem resultados para esse ID!"));

        entity.setNome(pessoa.getNome());
        entity.setSobrenome(pessoa.getSobrenome());
        entity.setEndereco(pessoa.getEndereco());
        entity.setGenero(pessoa.getGenero());

        var vo = DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
        return vo;
    }

    public void deletar(Long id) {
        Pessoa entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sem resultados para esse ID!"));
        repository.delete(entity);
    }

    @Transactional
    public PessoaVO disablePerson(Long id) {
        repository.disablePerson(id);
        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sem resultados para esse ID!"));
        return DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
    }

    public PessoaVO buscarPorId(Long id) {
        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sem resultados para esse ID!"));
        return DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
    }

    public List<PessoaVO> buscarTodos() {
        return DozerConverter.parseListObject(repository.findAll(), PessoaVO.class);
    }

    public Page<PessoaVO> findAllPaginate(Pageable pageable) {
        var page = repository.findAll(pageable);

        return page.map(this::convertToPersonVO);
    }

    public Page<PessoaVO> findPersonByName(String fistname, Pageable pageable) {
        var page = repository.findPersonByName(fistname, pageable);

        return page.map(this::convertToPersonVO);
    }

    private PessoaVO convertToPersonVO(Pessoa pessoa) {
        return DozerConverter.parseObject(repository.save(pessoa), PessoaVO.class);
    }
}
