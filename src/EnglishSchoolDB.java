import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnglishSchoolDB implements StudentService {

    public static final String URL = "jdbc:mysql://localhost:3306/englishschool";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "123456";

    @Override
    public Students saveStudent(int idGroupSt, String fname, String sname, String lname, String phone) {
        registrationDriver();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Students student = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(SqlRequests.INSERT_STUDENT);

            preparedStatement.setInt(1, idGroupSt);
            preparedStatement.setString(2, fname);
            preparedStatement.setString(3, sname);
            preparedStatement.setString(4, lname);
            preparedStatement.setString(5, phone);
            preparedStatement.execute();

            int idSudent = getStudentID(fname, lname);
            student = new Students(idSudent, idGroupSt, fname, sname, lname, phone);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }
        return student;
    }

    @Override
    public Students deleteStudentByID(int idStudent) {
        Students student = getStudent(idStudent);
        registrationDriver();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(SqlRequests.DELETE_STUDENT);
            preparedStatement.setInt(1, idStudent);
            int res = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }
        return student;
    }

    @Override
    public Students updateStudent(int idStudent, int idGroupSt) {

        Students student = getStudent(idStudent);
        registrationDriver();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(SqlRequests.UPDATE_STUDENT);
            preparedStatement.setInt(2, idStudent);
            preparedStatement.setInt(1, idGroupSt);
            int res = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }
        return student;
    }

    @Override
    public List<Students> getAllStudents() {
        registrationDriver();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Students> allStudents = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(SqlRequests.GET_ALL_STUDENTS);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idStudent = rs.getInt(1);
                int idGroupSt = rs.getInt(2);
                String fname = rs.getString(3);
                String sname = rs.getString(4);
                String lname = rs.getString(5);
                String phone = rs.getString(6);
                Students student = new Students(idStudent, idGroupSt, fname, sname, lname, phone);
                allStudents.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }

        return allStudents;
    }

    @Override
    public int getStudentID(String firstName, String lastName) {
        registrationDriver();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int stID = 0;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(SqlRequests.STUDENT_ID);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.execute();

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                stID = rs.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }
        return stID;
    }

    @Override
    public Students getStudent(int idStudent) {
        Students student = null;
        registrationDriver();
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(SqlRequests.GET_STUDENT_BY_ID);

            preparedStatement.setInt(1, idStudent);
            preparedStatement.execute();

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idGroupSt = rs.getInt(2);
                String fname = rs.getString(3);
                String sname = rs.getString(4);
                String lname = rs.getString(5);
                String phone = rs.getString(6);
                student = new Students(idStudent, idGroupSt, fname, sname, lname, phone);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }

        return student;
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
