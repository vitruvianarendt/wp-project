package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {

    public List<Teacher> findAllTeachers() {
        return DataHolder.teachers;
    }
    public Teacher findById(Long id) {
        return DataHolder.teachers.stream().filter(r->r.getId().equals(id)).findFirst().orElse(DataHolder.teachers.get(0));
    }
    public void deleteById(Long id) {
        DataHolder.teachers.removeIf(i->i.getId().equals(id));
    }

    public Teacher saveTeacher (String name, String surname) {

        DataHolder.teachers.removeIf(i->i.getName().equals(name));
        Teacher t = new Teacher(name, surname);
        DataHolder.teachers.add(t);
        return t;
    }
}
