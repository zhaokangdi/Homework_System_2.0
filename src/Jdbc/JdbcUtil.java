package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql_database?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static Connection conn = null;
    public static PreparedStatement stmt = null;

    public void Connect() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void Close() {
        try {
            if(stmt!=null) stmt.close();
        } catch(SQLException se2){ }

        try {
            if(conn!=null) conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
