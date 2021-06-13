import java.util.List;

public interface StudentService {
    Students saveStudent(int idGroupSt, String fname, String sname, String lname, String phone);
    Students getStudent(int idStudent);
    int getStudentID(String firstName, String lastName);
    List<Students> getAllStudents();
    Students updateStudent(int idStudent, int idGroupSt);
    Students deleteStudentByID(int idStudent);

}
