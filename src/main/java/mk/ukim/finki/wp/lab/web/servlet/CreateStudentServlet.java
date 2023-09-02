package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create-student", urlPatterns = "/createStudent")
public class CreateStudentServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;

    public CreateStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process("addStudent.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getParameter("username");
        String password = (String)req.getParameter("password");
        String name = (String)req.getParameter("name");
        String surname = (String)req.getParameter("surname");
        studentService.save(username, password, name, surname);
        resp.sendRedirect("/AddStudent");
    }
}
