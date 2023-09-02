package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.jpa.JpaTeacherRepository;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    public final JpaTeacherRepository teacherRepository;

    public TeacherServiceImpl(JpaTeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> listAllTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return this.teacherRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.teacherRepository.deleteById(id);
    }
    public Teacher saveTeacher(String name, String surname) {
        return this.teacherRepository.save(new Teacher(name, surname));
    }
}
