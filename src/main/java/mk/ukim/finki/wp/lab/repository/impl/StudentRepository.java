package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Repository
public class StudentRepository {

    public List<Student> findAllStudents() {
        return DataHolder.students;
    }

    public List<Student> findAllByNameOrSurname(String text) {
        return DataHolder.students.stream().filter(r->r.getName().contains(text) || r.getSurname().contains(text)).collect(Collectors.toList());
    }

    public Student findByUsername(String name) {
         return DataHolder.students.stream().filter(r->r.getUsername().equals(name)).findFirst().orElse(DataHolder.students.get(0));
    }

    public Student saveOrUpdate(Student student) {
        DataHolder.students.removeIf(r->r.getUsername().equals(student.getUsername()));
        DataHolder.students.add(student);
        return student;
    }
}
