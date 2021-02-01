package br.com.natanmaia.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String sobrenome;

    @Column(nullable = false)
    private String endereco;

    @Column(length = 10)
    private String genero;

    @Column(nullable = false)
    private Boolean enabled;

    public Pessoa() {

    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;

        Pessoa pessoa = (Pessoa) o;

        if (!getId().equals(pessoa.getId())) return false;
        if (!getNome().equals(pessoa.getNome())) return false;
        if (!getSobrenome().equals(pessoa.getSobrenome())) return false;
        if (!getEndereco().equals(pessoa.getEndereco())) return false;
        if (!getGenero().equals(pessoa.getGenero())) return false;
        return getEnabled().equals(pessoa.getEnabled());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNome().hashCode();
        result = 31 * result + getSobrenome().hashCode();
        result = 31 * result + getEndereco().hashCode();
        result = 31 * result + getGenero().hashCode();
        result = 31 * result + getEnabled().hashCode();
        return result;
    }
}
