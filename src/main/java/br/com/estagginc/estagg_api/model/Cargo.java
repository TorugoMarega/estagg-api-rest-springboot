package br.com.estagginc.estagg_api.model;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
//@SQLDelete(sql = "UPDATE user SET deleted=true WHERE id=?")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;


    @Column(nullable = false)
    private Boolean deleted = Boolean.FALSE;
    public Cargo(){}

    public Cargo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}