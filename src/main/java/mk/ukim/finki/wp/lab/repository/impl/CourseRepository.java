package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.exceptions.CourseNotChosenException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CourseRepository {

    public List<Course> findAllCourses() {
        return DataHolder.courses;
    }

    public Course findById(Long courseId) {
       return DataHolder.courses.stream().filter(r->r.getCourseId().equals(courseId)).findFirst().orElse(DataHolder.courses.get(0));

    }
    public Course findByName(String name) {
        return DataHolder.courses.stream().filter(r->r.getName().equals(name)).findFirst().orElse(null);

    }

    public  List<Student> findAllStudentsByCourse(Long courseId) {
        Course course = findById(courseId);
        return course.getStudents();
    }

    public Course addStudentToCourse(Student student, Course course) {
         course.getStudents().add(student);
         return course;
    }

    public Long checkCourseId (Long courseId) {
        if(courseId == null)
            throw new CourseNotChosenException();
        else return courseId;
    }

    public Course saveCourse (String name, String description, Long id) {
        Course test = findByName(name);
        if(test!=null) {
            DataHolder.courses.removeIf(i->i.getCourseId().equals((test.getCourseId())));
        }
        Teacher teacher = DataHolder.teachers.stream().filter(r->r.getId().equals(id)).findFirst().orElse(DataHolder.teachers.get(0));
        Course c = new Course(name, description, teacher);
        DataHolder.courses.add(c);
        return c;
    }
    public void deleteById(Long id) {
        DataHolder.courses.removeIf(i->i.getCourseId().equals(id));
    }
}
