package Servlet;

import Jdbc.StudentJdbc;
import Model.Homework;
import Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentHomeworkListServlet")
public class StudentHomeworkListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String student_name = (String) req.getSession().getAttribute("student_name");
        Student student = new Student(student_name);
        StudentJdbc student_jdbc = new StudentJdbc();
        List<Homework> homework_list = student_jdbc.QueryHomework(student);
        req.setAttribute("homework_list", homework_list);

        req.getRequestDispatcher("student_submit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
