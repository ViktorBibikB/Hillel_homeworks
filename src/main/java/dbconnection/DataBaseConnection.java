package dbconnection;

import java.sql.*;

public class DataBaseConnection implements AutoCloseable {
    private static DataBaseConnection dataBaseConnection;
    private static Connection connection;

    private static final String url = "jdbc:mysql://localhost:3306/test_mysql_db";
    private static final String username = System.getenv("MYSQL_USER");
    private static final String password = System.getenv("MYSQL_PASSWORD");

    private DataBaseConnection() {
    }

    public static DataBaseConnection getInstance() {
        if (dataBaseConnection == null)
            dataBaseConnection = new DataBaseConnection();
        return dataBaseConnection;
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
