package mk.ukim.finki.wp.lab.bootstrap;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Data
public class DataHolder {

    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();


//    @PostConstruct
//    public void init () {
//
//        students.add(new Student("hana.hasanicaj", "hh", "Hana", "Hasanicaj"));
//        students.add(new Student("emma.white", "ew", "Emma", "White"));
//        students.add(new Student("jessica.smith", "js", "Jessica", "Smith"));
//        students.add(new Student("sarah.white", "sw", "Sarah", "White"));
//        students.add(new Student("alice.james", "aj", "Alice", "James"));
//
//        teachers.add(new Teacher("Finki", "Finkov"));
//        teachers.add(new Teacher("Riste", "Ristov"));
//        teachers.add(new Teacher("Petar", "Petroski"));
//        teachers.add(new Teacher("Marko", "Markoski"));
//
//        Teacher teacher = new Teacher("Petko", "Petkoski");
//        teachers.add(teacher);
//
//
//        courses.add(new Course("Web Programming", "Web programming refers to the writing, markup and coding involved in Web development.", teachers.get(0)));
//        courses.add(new Course("Operating Systems", "This course teaches the basic operating system abstractions.",   teachers.get(1)));
//        courses.add(new Course("E-Commerce", "E-commerce (electronic commerce) is the buying and selling of goods and services, or the transmitting of funds or data, over an electronic network, primarily the internet.",   teachers.get(2)));
//        courses.add(new Course("Computer Networks", "Computer networking is the study of how computers can be linked to share data.",   teachers.get(3)));
//        courses.add(new Course("Databases", "Database management courses introduce students to languages, applications and programming used for the design and maintenance of business databases.",  teachers.get(4)));
//
//    }
}
