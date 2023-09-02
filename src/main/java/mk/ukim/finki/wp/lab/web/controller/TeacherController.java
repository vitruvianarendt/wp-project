package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public TeacherController(CourseService courseService, StudentService studentService, TeacherService teacherService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }


    @GetMapping
    public String getTeachersPage(@RequestParam(required = false) String error, Model model, HttpServletRequest res) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Course> courses = this.courseService.listAll();
        List<Teacher> teachers = this.teacherService.listAllTeachers();
        res.getSession().setAttribute("courseId", courses.get(0).getCourseId());
        model.addAttribute("teachers", teachers);
        return "listTeachers";
    }

//    @GetMapping("/select-course/{id}")
//    public String selectCoursesPage(@PathVariable Long id, Model model, HttpServletRequest res) {
//        if(this.courseService.findCourseById(id)!=null) {
//
//            Course course = this.courseService.findCourseById(id);
//            List<Student> students = this.studentService.listAllStudents();
//            model.addAttribute("course", course);
//            model.addAttribute("students", students);
//            model.addAttribute("id", id);
//            res.getSession().setAttribute("courseId", id);
//            return "listStudents";
//        }
//        return "redirect:/courses?error=CourseNotFound";
//    }
//    @PostMapping("/select-student/{username}/{id}")
//    public String saveStudent(@PathVariable Long id, @PathVariable String username) {
//        Student s = studentService.findByUsername(username);
//        Course c = courseService.findCourseById(id);
//        this.courseService.addStudentInCourse(s, c);
//        return "redirect:/courses";
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        this.teacherService.deleteById(id);
        return "redirect:/teachers";
    }

    @GetMapping("/edit-form/{id}")
    public String editTeacherPage(@PathVariable Long id, Model model) {
        if(this.teacherService.findById(id)!=null){
            Teacher teacher = this.teacherService.findById(id).get();
            model.addAttribute("teacher", teacher);

            return "add-teacher";
        }
        return "redirect:/teachers?error=ProductNotFound";
    }


    @GetMapping("/add-form")
    public String addTeacherPage(Model model) {
//        List<Teacher> teachers = this.teacherService.listAllTeachers();
//        model.addAttribute("teachers", teachers);
        return "add-teacher";
    }

    @PostMapping("/add")
    public String save(@RequestParam String name,
                       @RequestParam String surname) {
        this.teacherService.saveTeacher(name, surname);
        return "redirect:/teachers";
    }
}
