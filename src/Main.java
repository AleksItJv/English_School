
public class Main {
    public static void main(String[] args) {

        EnglishSchoolDB englishSchoolBD = new EnglishSchoolDB();
        //englishSchoolBD.saveStudent(1,"Petro" ,"Petrovich", "Poroshenko", "380990008820");
        //englishSchoolBD.studentID("Petro", "Poroshenko");
        System.out.println("--------------------");
        //System .out.println(englishSchoolBD.getAllStudents());
        //englishSchoolBD.deleteStudentByID(6);
        englishSchoolBD.updateStudent(1, 3);
        //System.out.println(englishSchoolBD.getStudent(3));
        for (Students student : englishSchoolBD.getAllStudents()) {
            System.out.println(student);
        }
    }
}
