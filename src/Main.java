import entity.Student;

public class Main {
    public static void main(String[] args) {

        EnglishSchoolDB englishSchoolBD = new EnglishSchoolDB();

        Student student = new Student();
        student.setIdGroup(1);
        student.setFname("Oleg");
        student.setSname("Nikolaevich");
        student.setLname("Bogatov");
        student.setPhone("103");
        englishSchoolBD.saveStudent(student);
        //englishSchoolBD.saveStudent(1,"Petro" ,"Petrovich", "Poroshenko", "380990008820");
        //englishSchoolBD.studentID("Petro", "Poroshenko");
        System.out.println("--------------------");
        //System .out.println(englishSchoolBD.getAllStudents());
        //englishSchoolBD.deleteStudentByID(6);
        englishSchoolBD.updateStudent(1, 3);
        //System.out.println(englishSchoolBD.getStudent(3));


        for (Student studentLoop : englishSchoolBD.getAllStudentsByGroupSt(2)) {
            System.out.println(studentLoop);
        }
    }
}
