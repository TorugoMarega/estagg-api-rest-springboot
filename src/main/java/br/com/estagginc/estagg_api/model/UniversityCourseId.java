package br.com.estagginc.estagg_api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UniversityCourseId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "university_id")
    private Long university_id;

    @Column(name = "course_id")
    private Long course_id;

    public UniversityCourseId() {
    }

    public UniversityCourseId(Long university_id, Long course_id) {
        this.university_id = university_id;
        this.course_id = course_id;
    }

    public Long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Long university_id) {
        this.university_id = university_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityCourseId that = (UniversityCourseId) o;
        return Objects.equals(university_id, that.university_id) && Objects.equals(course_id, that.course_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(university_id, course_id);
    }
}
