package Servlet;

import Jdbc.StudentJdbc;
import Jdbc.TeacherJdbc;
import Model.Homework;
import Model.Student;
import Model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String login_name = (String) req.getParameter("login_name");
        String login_identity = (String) req.getParameter("login_identity");

        if(login_identity.equals("学生")) {
            Student student = new Student(login_name);
            StudentJdbc student_jdbc = new StudentJdbc();
            List<Homework> homework_list = student_jdbc.QueryHomework(student);
            req.setAttribute("homework_list", homework_list);

            req.getSession().setAttribute("student_name",login_name);
            req.getRequestDispatcher("student_submit.jsp").forward(req, resp);
        }else {
            Teacher teacher = new Teacher(login_name);
            TeacherJdbc teacher_jdbc = new TeacherJdbc();
            List<Homework> homework_list = teacher_jdbc.QueryHomework(teacher);
            req.setAttribute("homework_list", homework_list);

            req.getSession().setAttribute("teacher_name",login_name);
            req.getRequestDispatcher("teacher_homework.jsp").forward(req, resp);
        }
    }
}
