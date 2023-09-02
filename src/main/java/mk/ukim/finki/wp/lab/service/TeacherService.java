package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

     List<Teacher> listAllTeachers();
     Optional<Teacher> findById(Long id);
     void deleteById(Long id);
     Teacher saveTeacher(String name, String surname);
}
