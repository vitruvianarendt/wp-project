package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="number", urlPatterns ="/number")
public class NumberOfStudentsServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;
    private final StudentService studentService;

    public NumberOfStudentsServlet(SpringTemplateEngine springTemplateEngine, CourseService courseService, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        String username = (String) req.getSession().getAttribute("studentId");
//        Long courseId = (Long) req.getSession().getAttribute("courseId");
//        Student s = studentService.findByUsername(username);
//        Course c = courseService.findCourseById(courseId);
//        context.setVariable("course", c.getName());
//        courseService.addStudentInCourse(s, c);
//        context.setVariable("students", courseService.listStudentsByCourse(courseId));
        context.setVariable("courses", this.courseService.listAll());

        this.springTemplateEngine.process("numberOfStudents.html", context, resp.getWriter());
    }
}
