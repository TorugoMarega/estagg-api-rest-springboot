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

    private String name;

    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private Occupation occupation;

    public Person() {
    }

    public Person(Long id, String name, Boolean deleted, Occupation occupation) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(deleted, person.deleted) && Objects.equals(occupation, person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deleted, occupation);
    }
}
