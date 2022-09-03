package br.com.estagginc.estagg_api.model;

import javax.persistence.*;

@Entity
@Table(name = "instituicao")
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nome;
    public Instituicao(){}

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
}