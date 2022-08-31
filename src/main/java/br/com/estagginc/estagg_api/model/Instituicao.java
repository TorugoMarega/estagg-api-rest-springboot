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
}