package ch06;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceDAO {
    Connection conn = null;
    PreparedStatement pstmt;
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String JDBC_URL = "jdbc:mysql://localhost:3306/jwbook?serverTimezone=Asia/Seoul";

    public void open() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StudentServiceDAO() {

    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement("select * from student");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setUniv(rs.getString("univ"));
                s.setBirth(rs.getDate("birth"));
                s.setEmail(rs.getString("email"));
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public Student findById(String id) {
        Student student = new Student();

        try {
            pstmt = conn.prepareStatement("select * from student where id=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setUniv(rs.getString("univ"));
            student.setBirth(rs.getDate("birth"));
            student.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public void update(int id, String name, String email) {
        try {
            pstmt = conn.prepareStatement("update student set name=?, email=? where id=?");
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            int res = pstmt.executeUpdate();
            if (res == 1) {
                System.out.println("수정 완료");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void delete(int id) {
        try {
            pstmt = conn.prepareStatement("delete from student where id=?");
            pstmt.setInt(1, id);
            int res = pstmt.executeUpdate();
            if (res == 1) {
                System.out.println("삭제 완료");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void insert(Student student) {
        try {
            pstmt = conn.prepareStatement("insert into student(name, univ, birth, email) values(?, ?, ?, ?)");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getUniv());
            pstmt.setDate(3, student.getBirth());
            pstmt.setString(4, student.getEmail());
            int res = pstmt.executeUpdate();
            if (res == 1) {
                System.out.println("등록 완료");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
