import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EnglishSchoolBD {
    public static final String URL = "jdbc:mysql://localhost:3306/englishschool";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "123456";

    public boolean saveStudent(){
        registrationDriver();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement("");



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, statement);
        }


        return false;
    }


    private void closeConnections(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static void registrationDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
