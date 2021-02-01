package br.com.natanmaia.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.natanmaia.data.models.Pessoa;
import br.com.natanmaia.data.vo.PessoaVO;

public class MockPessoa {

    public Pessoa mockEntity() {
        return mockEntity(0);
    }

    public PessoaVO mockVO() {
        return mockVO(0);
    }

    public List<Pessoa> mockEntityList() {
        List<Pessoa> pessoas = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            pessoas.add(mockEntity(i));
        }
        return pessoas;
    }

    public List<PessoaVO> mockVOList() {
        List<PessoaVO> pessoaVOs = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            pessoaVOs.add(mockVO(i));
        }
        return pessoaVOs;
    }

    private Pessoa mockEntity(Integer number) {
        Pessoa pessoa = new Pessoa();
        pessoa.setEndereco("Endereço teste" + number);
        pessoa.setGenero(((number % 2) == 0) ? "Masculino" : "Feminino");
        pessoa.setNome("Nome teste" + number);
        pessoa.setSobrenome("Sobrenome teste" + number);
        pessoa.setId(number.longValue());
        return pessoa;
    }

    private PessoaVO mockVO(Integer number) {
        PessoaVO pessoa = new PessoaVO();
        pessoa.setEndereco("Endereço teste" + number);
        pessoa.setGenero(((number % 2) == 0) ? "Masculino" : "Feminino");
        pessoa.setNome("Nome teste" + number);
        pessoa.setSobrenome("Sobrenome teste" + number);
        pessoa.setKey(number.longValue());
        return pessoa;
    }
}
