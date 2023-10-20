package ch06;

import java.sql.*;
import java.util.*;

public class ProductServiceDAO {
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

    public ProductServiceDAO() {

    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement("select * from product");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setMaker(rs.getString("maker"));
                p.setPrice(rs.getInt("price"));
                p.setDate(rs.getString("date"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public Product findById(String id) {
        Product product = new Product();

        try {
            pstmt = conn.prepareStatement("select * from product where id=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            product.setId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setMaker(rs.getString("maker"));
            product.setPrice(rs.getInt("price"));
            product.setDate(rs.getString("date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }
}
