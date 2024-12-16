package dao;

import db.DatabaseConnection;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO stock (item_name, description, category, quantity, price, on_sale) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getItemName());
            pstmt.setString(2, product.getDescription());
            pstmt.setString(3, product.getCategory());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setInt(5, product.getPrice());
            pstmt.setBoolean(6, product.isOnSale());
            pstmt.executeUpdate();
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM stock";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("id"),
                    rs.getString("item_name"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getInt("quantity"),
                    rs.getInt("price"),
                    rs.getBoolean("on_sale")
                );
                products.add(product);
            }
        }
        return products;
    }
}
