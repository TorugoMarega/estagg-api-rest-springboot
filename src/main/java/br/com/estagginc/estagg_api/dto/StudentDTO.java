package br.com.estagginc.estagg_api.dto;


import br.com.estagginc.estagg_api.model.Occupation;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private Occupation occupation;
    private CourseDTO course;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String cpf, Occupation occupation, CourseDTO course) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.occupation = occupation;
        this.course = course;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }
}
