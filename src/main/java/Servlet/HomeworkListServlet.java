package Servlet;

import Jdbc.TeacherJdbc;
import Model.Homework;
import Model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HomeworkListServlet")
public class HomeworkListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String teacher_name = (String) req.getSession().getAttribute("teacher_name");
        Teacher teacher = new Teacher(teacher_name);
        TeacherJdbc teacher_jdbc = new TeacherJdbc();
        List<Homework> homework_list = teacher_jdbc.QueryHomework(teacher);
        req.setAttribute("homework_list", homework_list);

        req.getRequestDispatcher("teacher_homework.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
