import connection.Connector;
import entity.SqlRequests;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnglishSchoolDB implements StudentService {

    @Override
    public Student saveStudent(Student student) {
        registrationDriver();
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connection.prepareStatement(SqlRequests.INSERT_STUDENT);

            preparedStatement.setInt(1, student.getIdGroup());
            preparedStatement.setString(2, student.getFname());
            preparedStatement.setString(3, student.getSname());
            preparedStatement.setString(4, student.getLname());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnections(connection, preparedStatement);
        }
        return student;
    }

    @Override
    public Student deleteStudentByID(int idStudent) {
        Student student = getStudent(idStudent);
        registrationDriver();
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;

        try {
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
    public Student updateStudent(int idStudent, int idGroupSt) {

        Student student = getStudent(idStudent);
        registrationDriver();
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;

        try {
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
    public List<Student> getAllStudents() {
        registrationDriver();
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        List<Student> allStudents = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SqlRequests.GET_ALL_STUDENTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idStudent = rs.getInt(1);
                int idGroupSt = rs.getInt(2);
                String fname = rs.getString(3);
                String sname = rs.getString(4);
                String lname = rs.getString(5);
                String phone = rs.getString(6);
                Student student = new Student(idStudent, idGroupSt, fname, sname, lname, phone);
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
    public List<Student> getAllStudentsByGroupSt(int idGroupSt) {
        registrationDriver();
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        List<Student> allStudents = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SqlRequests.GET_ALL_STUDENTS_BY_GROUPST);
            preparedStatement.setInt(1, idGroupSt);
            preparedStatement.execute();

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idStudent = rs.getInt(1);
                String fname = rs.getString(3);
                String sname = rs.getString(4);
                String lname = rs.getString(5);
                String phone = rs.getString(6);
                Student student = new Student(idStudent, idGroupSt, fname, sname, lname, phone);
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
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;
        int stID = 0;

        try {
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
    public Student getStudent(int idStudent) {
        Student student = null;
        registrationDriver();
        Connection connection = Connector.getConnection();
        PreparedStatement preparedStatement = null;


        try {
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
                student = new Student(idStudent, idGroupSt, fname, sname, lname, phone);
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
