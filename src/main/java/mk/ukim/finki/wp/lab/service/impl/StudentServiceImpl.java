package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.jpa.JpaStudentRepository;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
StudentServiceImpl implements StudentService {

    public final JpaStudentRepository studentRepository;

    public StudentServiceImpl (JpaStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByNameOrSurname(String text) {
        return studentRepository.findAllByNameLike(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        Student c = new Student(username, password, name, surname);
        return studentRepository.save(c);
    }

    @Override
    public Student findByUsername(String text) {
        return studentRepository.findByUsername(text);
    }
}
