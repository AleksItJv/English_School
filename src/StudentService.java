import entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudent(int idStudent);
    int getStudentID(String firstName, String lastName);
    List<Student> getAllStudents();
    List<Student> getAllStudentsByGroupSt(int idGroupSt);
    Student updateStudent(int idStudent, int idGroupSt);
    Student deleteStudentByID(int idStudent);

}
