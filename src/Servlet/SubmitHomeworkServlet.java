package Servlet;

import Jdbc.StudentJdbc;
import Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SubmitHomeworkServlet")
public class SubmitHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String homework_title = (String) req.getParameter("homework_title");
        String teacher_name = (String) req.getParameter("teacher_name");
        String student_name = (String) req.getSession().getAttribute("student_name");
        Student student = new Student(student_name);
        String content = req.getParameter("content");
        StudentJdbc student_jdbc = new StudentJdbc();
        student_jdbc.InsertSubmit(homework_title, teacher_name, student, content);

        resp.sendRedirect("StudentHomeworkListServlet");
    }
}
