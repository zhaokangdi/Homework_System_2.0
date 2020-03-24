package Servlet;

import Jdbc.StudentJdbc;
import Jdbc.TeacherJdbc;
import Model.Student;
import Model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class
RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String register_name = (String) req.getParameter("register_name");
        String register_identity = (String) req.getParameter("register_identity");

        if(register_identity.equals("学生")) {
            Student student = new Student(register_name);
            StudentJdbc student_jdbc = new StudentJdbc();
            student_jdbc.InsertStudent(student);
        }else {
            Teacher teacher = new Teacher(register_name);
            TeacherJdbc teacher_jdbc = new TeacherJdbc();
            teacher_jdbc.AddTeacher(teacher);
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
