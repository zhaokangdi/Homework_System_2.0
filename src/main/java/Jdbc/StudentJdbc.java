package Jdbc;

import Model.Homework;
import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    JdbcUtil jdbc_util = new JdbcUtil();

    public void InsertStudent(Student student) {
        jdbc_util.Connect();

        String sql;
        sql = "INSERT INTO STUDENT VALUES (?)";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, student.getStudent_name());
            jdbc_util.stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
    }

    public List<Homework> QueryHomework(Student student) {
        jdbc_util.Connect();

        List<Homework> homework_list = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM HOMEWORK WHERE HOMEWORK.TEACHER_NAME IN (SELECT TEACH.TEACHER_NAME FROM TEACH WHERE STUDENT_NAME=?)";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, student.getStudent_name());
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

    public boolean QuerySubmit(Student student, String homework_title, String teacher_name) {
        jdbc_util.Connect();

        Integer number = 0;
        String sql;
        sql = "SELECT COUNT(*) FROM SUBMIT WHERE HOMEWORK_TITLE=? AND TEACHER_NAME=? AND STUDENT_NAME=?";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, homework_title);
            jdbc_util.stmt.setString(2, teacher_name);
            jdbc_util.stmt.setString(3, student.getStudent_name());
            ResultSet rs = jdbc_util.stmt.executeQuery();
            if(rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
        if(number == 0) {
            return true;
        }else {
            return false;
        }
    }

    public void InsertSubmit(String homework_title, String teacher_name, Student student, String content) {
        jdbc_util.Connect();

        String sql;
        sql = "INSERT INTO SUBMIT VALUES (?,?,?,?)";
        try {
            jdbc_util.stmt = jdbc_util.conn.prepareStatement(sql);
            jdbc_util.stmt.setString(1, homework_title);
            jdbc_util.stmt.setString(2, teacher_name);
            jdbc_util.stmt.setString(3, student.getStudent_name());
            jdbc_util.stmt.setString(4, content);
            jdbc_util.stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbc_util.Close();
    }
}
