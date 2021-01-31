package br.com.natanmaia.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


@JsonPropertyOrder({"id", "endereco", "nome", "sobrenome", "genero", "enabled"})
public class PessoaVO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String nome;
    private String sobrenome;
    private String endereco;

    @JsonProperty("sexo")
    private String genero;

    private Boolean enabled;

    public PessoaVO() {

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaVO)) return false;
        if (!super.equals(o)) return false;

        PessoaVO pessoaVO = (PessoaVO) o;

        if (!getKey().equals(pessoaVO.getKey())) return false;
        if (!getNome().equals(pessoaVO.getNome())) return false;
        if (!getSobrenome().equals(pessoaVO.getSobrenome())) return false;
        if (!getEndereco().equals(pessoaVO.getEndereco())) return false;
        if (!getGenero().equals(pessoaVO.getGenero())) return false;
        return getEnabled().equals(pessoaVO.getEnabled());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getKey().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getSobrenome().hashCode();
        result = 31 * result + getEndereco().hashCode();
        result = 31 * result + getGenero().hashCode();
        result = 31 * result + getEnabled().hashCode();
        return result;
    }
}
