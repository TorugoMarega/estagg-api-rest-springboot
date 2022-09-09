package br.com.estagginc.estagg_api.dto;

import br.com.estagginc.estagg_api.model.Cargo;
import br.com.estagginc.estagg_api.model.Pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PessoaDTO implements Serializable {
    private  Long id;
    private  String nome;
    private  String cpf;
    private  LocalDate data_nasc;
    private  String foto_perfil = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Breezeicons-actions-22-im-user.svg/1200px-Breezeicons-actions-22-im-user.svg.png";
    private  Cargo cargo;

    public PessoaDTO(Long id, String nome, String cpf, LocalDate data_nasc, String foto_perfil, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.foto_perfil = foto_perfil;
        this.cargo = cargo;
    }
//
//    public PessoaDTO(Pessoa pessoa) {
//    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDTO entity = (PessoaDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.cpf, entity.cpf) &&
                Objects.equals(this.data_nasc, entity.data_nasc) &&
                Objects.equals(this.foto_perfil, entity.foto_perfil) &&
                Objects.equals(this.cargo, entity.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, data_nasc, foto_perfil, cargo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "cpf = " + cpf + ", " +
                "data_nasc = " + data_nasc + ", " +
                "foto_perfil = " + foto_perfil + ", " +
                "cargo = " + cargo + ")";
    }
}
