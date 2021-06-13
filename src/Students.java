public class Students {

    private int idSudent;
    private int idGroup;
    private String fname;
    private String sname;
    private String lname;
    private String phone;

    public Students(int idStudent, int idGroup, String fname, String sname, String lname, String phone) {
        this.idSudent = idStudent;
        this.idGroup = idGroup;
        this.fname = fname;
        this.sname = sname;
        this.lname = lname;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Students{" +
                "idSudent=" + idSudent +
                ", idGroup=" + idGroup +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
