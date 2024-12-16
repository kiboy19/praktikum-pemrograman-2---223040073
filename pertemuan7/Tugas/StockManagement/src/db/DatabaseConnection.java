package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/stock_management";
    private static final String DB_USER = "root";  // sesuaikan dengan username MySQL Anda
    private static final String DB_PASS = "";  // sesuaikan dengan password MySQL Anda

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
