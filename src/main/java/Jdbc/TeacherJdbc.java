package Jdbc;

import Model.Homework;
import Model.Student;
import Model.Submit;
import Model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherJdbc {
    JdbcUtil jdbc_util = new JdbcUtil();

    public void AddTeacher(Teacher teacher) {
        jdbc_util.Connect();

        String sql;
        sql = "INSERT INTO TEACHER VALUES (?)";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, teacher.getTeacher_name());
            jdbc_util.stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
    }

    public List<Homework> QueryHomework(Teacher teacher) {
        jdbc_util.Connect();

        List<Homework> homework_list = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM HOMEWORK WHERE TEACHER_NAME=?";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, teacher.getTeacher_name());
            ResultSet rs = jdbc_util.stmt.executeQuery();
            while (rs.next()) {
                Homework homework = new Homework();
                homework.setHomework_title(rs.getString("homework_title"));
                homework.setTeacher_name(rs.getString("teacher_name"));
                homework_list.add(homework);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
        return homework_list;
    }

    public void AddHomework(Teacher teacher, String homework_title) {
        jdbc_util.Connect();

        String sql;
        sql = "INSERT INTO HOMEWORK VALUES (?,?)";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, homework_title);
            jdbc_util.stmt.setString(2, teacher.getTeacher_name());
            jdbc_util.stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
    }

    public void AddStudent(Teacher teacher, String student_name) {
        jdbc_util.Connect();

        String sql;
        sql = "INSERT INTO TEACH VALUES (?,?)";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, teacher.getTeacher_name());
            jdbc_util.stmt.setString(2, student_name);
            jdbc_util.stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
    }

    public List<Student> QueryStudent(Teacher teacher) {
        jdbc_util.Connect();
        List<Student> student_list = new ArrayList<>();

        String sql;
        sql = "SELECT * FROM TEACH WHERE TEACHER_NAME=?";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, teacher.getTeacher_name());

            ResultSet rs = jdbc_util.stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getString("student_name"));
                student.setStudent_name(rs.getString("student_name"));
                student_list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
        return student_list;
    }

    public List<Submit> QuerySubmit(String homework_title, Teacher teacher) {
        jdbc_util.Connect();
        List<Submit> submit_list = new ArrayList<>();

        String sql;
        sql = "SELECT * FROM SUBMIT WHERE HOMEWORK_TITLE=? and TEACHER_NAME=?";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, homework_title);
            jdbc_util.stmt.setString(2, teacher.getTeacher_name());

            ResultSet rs = jdbc_util.stmt.executeQuery();
            while (rs.next()) {
                Submit submit = new Submit();
                submit.setHomework_title(homework_title);
                submit.setTeacher_name(teacher.getTeacher_name());
                submit.setStudent_name(rs.getString("student_name"));
                submit.setContent(rs.getString("content"));
                submit_list.add(submit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
        return submit_list;
    }

    public String CheckContent(String homework_title, Teacher teacher, String student_name) {
        jdbc_util.Connect();
        String content = null;

        String sql;
        sql = "SELECT CONTENT FROM SUBMIT WHERE HOMEWORK_TITLE=? and TEACHER_NAME=? and STUDENT_NAME=?";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, homework_title);
            jdbc_util.stmt.setString(2, teacher.getTeacher_name());
            jdbc_util.stmt.setString(3, student_name);
            ResultSet rs = jdbc_util.stmt.executeQuery();
            if(rs.next()) {
                content = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
        return content;
    }
}
