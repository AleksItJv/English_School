package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static final String URL = "jdbc:mysql://localhost:3306/englishschool";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "123456";
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
