package br.com.estagginc.estagg_api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;

    private String cpf;

    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private Occupation occupation;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;





    public Person() {
    }

    public Person(Long id, String first_name, String last_name, String cpf, Occupation occupation, Course course, Boolean deleted) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.cpf = cpf;
        this.deleted = deleted;
        this.occupation = occupation;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
