package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.enumerations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;
    private String description;
    @ManyToMany
    private List<Student> students;
    @ManyToOne
    private Teacher teacher;
    private Type type;

    public Course(String name, String description, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }

    public Course() {

    }
}
