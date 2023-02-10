package dbconnection;

import java.sql.*;

public class DataBaseConnection {
    Connection connection;

    String url = "jdbc:mysql://localhost:3306/test_mysql_db";
    String username = System.getenv("MYSQL_USER");
    String password = System.getenv("MYSQL_PASSWORD");

    public Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close (Connection connection){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
