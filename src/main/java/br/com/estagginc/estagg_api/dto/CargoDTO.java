package br.com.estagginc.estagg_api.dto;

import br.com.estagginc.estagg_api.model.Cargo;


public class CargoDTO {

    private Long id;
    private String nome;


    public CargoDTO() {
    }


    public CargoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CargoDTO(Cargo cargo) {
        this.id = cargo.getId();
        this.nome = cargo.getNome();
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
}
