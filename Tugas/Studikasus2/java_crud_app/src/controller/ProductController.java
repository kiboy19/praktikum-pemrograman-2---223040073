package controller;

import model.Product;
import model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM products";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            products.add(new Product(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("category"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock")
            ));
        }

        return products;
    }

    public void insertProduct(Product product) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO products (name, category, price, stock) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCategory());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getStock());
        preparedStatement.executeUpdate();
    }

    public void updateProduct(Product product) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE products SET name = ?, category = ?, price = ?, stock = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCategory());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getStock());
        preparedStatement.setInt(5, product.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteProduct(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM products WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}