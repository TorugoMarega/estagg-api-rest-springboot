package br.com.estagginc.estagg_api.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cargo")
@SQLDelete(sql = "UPDATE user SET deleted=true WHERE id=?")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String nome;
    @OneToMany
    private List<Pessoa> pessoas;
    private Boolean deleted = Boolean.FALSE;
    private Cargo(){}

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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}