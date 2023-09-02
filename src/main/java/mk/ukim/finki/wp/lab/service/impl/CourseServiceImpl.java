package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.jpa.JpaCourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaStudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaTeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    public final JpaCourseRepository courseRepository;
    public final JpaTeacherRepository teacherRepository;
    public final JpaStudentRepository studentRepository;

    public CourseServiceImpl(JpaCourseRepository courseRepository, JpaTeacherRepository teacherRepository, JpaStudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> findAllByCourseId(Long courseId) {
        return courseRepository.findAllByCourseId(courseId);
    }

    @Override
    public Course addStudentInCourse(Student student, Course course) {
        Course c = findCourseById(course.getCourseId()).get();
        c.getStudents().add(student);
        courseRepository.save(course);
        return course;
    }
    @Override
    public Course addGradeInCourse(Student student, Course course) {
        Course c = findCourseById(course.getCourseId()).get();
        c.getStudents().add(student);
        courseRepository.save(course);
        return course;
    }

    @Override
    public Optional<Course> findCourseById(Long Id) {
        return courseRepository.findById(Id);
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public Optional<Course> findById(Long Id) {
        return courseRepository.findById(Id);
    }

    @Override
    public Course saveCourse(String name, String description, Long id) {
        Teacher t=teacherRepository.getById(id);
        return this.courseRepository.save(new Course(name, description, t));
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

}
