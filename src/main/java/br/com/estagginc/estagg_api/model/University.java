package br.com.estagginc.estagg_api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class University implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UniversityCourse> universities = new ArrayList<>();
    public University() {
    }

    public University(Long id, String name, List<UniversityCourse> universities) {
        this.id = id;
        this.name = name;
        this.universities = universities;
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

    public List<UniversityCourse> getUniversities() {
        return universities;
    }

    public void setUniversities(List<UniversityCourse> universities) {
        this.universities = universities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(universities, that.universities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, universities);
    }
}

