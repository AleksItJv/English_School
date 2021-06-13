public class SqlRequests {
    public static final String INSERT_STUDENT = "INSERT INTO students (idGroupSt, fname, sname, lname, phone)\n" +
            "values (?, ?, ?, ?, ?);";
    public static final String STUDENT_ID = "SELECT students.idStudent FROM students WHERE fname = ? AND lname = ? ";
    public static final String GET_STUDENT_BY_ID = "SELECT * FROM students WHERE idStudent = ?";
    public static final String GET_ALL_STUDENTS = "SELECT * FROM students";
    public static final String DELETE_STUDENT = "DELETE FROM students WHERE idStudent = ?";
    public static final String UPDATE_STUDENT = "UPDATE students SET idGroupSt = ? WHERE idStudent = ?";
}
