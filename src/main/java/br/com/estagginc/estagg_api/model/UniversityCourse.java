package br.com.estagginc.estagg_api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UniversityCourse {
    @EmbeddedId
    private UniversityCourseId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("universityId")
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;

    public UniversityCourse() {
    }

    public UniversityCourse(UniversityCourseId id, University university, Course course) {
        this.id = id;
        this.university = university;
        this.course = course;
    }

    public UniversityCourseId getId() {
        return id;
    }

    public void setId(UniversityCourseId id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityCourse that = (UniversityCourse) o;
        return Objects.equals(id, that.id) && Objects.equals(university, that.university) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, university, course);
    }
}
