package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listAll();
    List<Student> findAllByCourseId(Long courseId);
    Course addStudentInCourse(Student student, Course course);
    Course addGradeInCourse(Student student, Course course);
    Optional<Course> findCourseById(Long Id);
    Course findByName(String name);
    Optional<Course> findById (Long Id);
    Course saveCourse(String name, String description, Long id);
    void deleteById(Long id);

}
