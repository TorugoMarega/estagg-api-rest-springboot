package br.com.estagginc.estagg_api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Vagas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @ManyToMany
    private List<Pessoa> candidato;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Vagas() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getCandidato() {
        return candidato;
    }

    public void setCandidato(List<Pessoa> candidato) {
        this.candidato = candidato;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
