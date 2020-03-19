package Servlet;

import Jdbc.TeacherJdbc;
import Model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddHomeworkServlet")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String teacher_name = (String) req.getSession().getAttribute("teacher_name");
        String homework_title = (String) req.getParameter("homework_title");
        System.out.println(teacher_name + homework_title);
        Teacher teacher = new Teacher(teacher_name);
        TeacherJdbc teacher_jdbc = new TeacherJdbc();
        teacher_jdbc.AddHomework(teacher, homework_title);

        resp.sendRedirect("HomeworkListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
