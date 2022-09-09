package br.com.estagginc.estagg_api.model;


import br.com.estagginc.estagg_api.dto.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(columnDefinition = "DATE")
    private LocalDate data_nasc;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String senha_hash;


    private boolean deleted = false;
    private String foto_perfil;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id", unique = true)
    private Cargo cargo;

    public Pessoa(){ }

    public Pessoa(Long id, String nome, String cpf, Instituicao instituicao, Curso curso, LocalDate data_nasc, String email, String senha_hash, Cargo cargo, boolean deleted, String foto_perfil) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.instituicao = instituicao;
        this.curso = curso;
        this.data_nasc = data_nasc;
        this.email = email;
        this.senha_hash = senha_hash;
        this.cargo = cargo;
        this.deleted = deleted;
        this.foto_perfil = foto_perfil;
    }

    public Pessoa(Long id, String nome, String cpf, LocalDate data_nasc, String email, String senha_hash, String foto_perfil) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.email = email;
        this.senha_hash = senha_hash;
        this.foto_perfil= foto_perfil;
    }

    public Pessoa (PessoaDTO pessoaDTO){
        this.id = pessoaDTO.getId();
        this.nome = pessoaDTO.getNome();
        this.cpf = pessoaDTO.getCpf();
        this.data_nasc = pessoaDTO.getData_nasc();
        this.foto_perfil = pessoaDTO.getFoto_perfil();
        this.cargo = pessoaDTO.getCargo();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha_hash() {
        return senha_hash;
    }

    public void setSenha_hash(String senha_hash) {
        this.senha_hash = senha_hash;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return deleted == pessoa.deleted && Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(instituicao, pessoa.instituicao) && Objects.equals(curso, pessoa.curso) && Objects.equals(data_nasc, pessoa.data_nasc) && Objects.equals(email, pessoa.email) && Objects.equals(senha_hash, pessoa.senha_hash) && Objects.equals(cargo, pessoa.cargo) && Objects.equals(foto_perfil, pessoa.foto_perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, instituicao, curso, data_nasc, email, senha_hash, cargo, deleted, foto_perfil);
    }
}
