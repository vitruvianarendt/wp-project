package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.GradeService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/grades")
public class GradeController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final GradeService gradeService;

    public GradeController(CourseService courseService, StudentService studentService, TeacherService teacherService, GradeService gradeService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.gradeService = gradeService;
    }


    @GetMapping("/add-form/{username}/{id}")
    public String selectGradesPage(@PathVariable Long id, @PathVariable String username, Model model, HttpServletRequest res) {
        if(this.courseService.findCourseById(id)!=null) {
            Course course = this.courseService.findCourseById(id).get();
            Student s = this.studentService.findByUsername(username);
            model.addAttribute("course", course);
            model.addAttribute("id", id);
            model.addAttribute("student", s);
            res.getSession().setAttribute("courseId", id);
            res.getSession().setAttribute("studentUsername", username);
            return "add-grade";
        }
        return "redirect:/courses?error=CourseNotFound";
    }
    @PostMapping("/add-grade/{username}/{id}")
    public String saveGrade(@PathVariable Long id,
                            @PathVariable String username,
                            @RequestParam Character grade,
                            @RequestParam
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        Student s = studentService.findByUsername(username);
        Course c = courseService.findCourseById(id).get();
        this.gradeService.saveGrade(grade, s, c, date);
        return "redirect:/courses";
    }

}
