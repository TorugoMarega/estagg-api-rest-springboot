package br.com.estagginc.estagg_api.dto;

public class PersonDTO {
    private Long id;
    private String name;
    private OccupationDTO occupation;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, OccupationDTO occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OccupationDTO getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationDTO occupation) {
        this.occupation = occupation;
    }
}
