package br.com.estagginc.estagg_api.model;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String cnpj;
    private String insc_estadual;
    private String cep;
    private String endereco;
    private String telefone;
    @OneToOne
    private Pessoa recurtador;

    public Empresa(){}

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInsc_estadual() {
        return insc_estadual;
    }

    public void setInsc_estadual(String insc_estadual) {
        this.insc_estadual = insc_estadual;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa getRecurtador() {
        return recurtador;
    }

    public void setRecurtador(Pessoa recurtador) {
        this.recurtador = recurtador;
    }
}