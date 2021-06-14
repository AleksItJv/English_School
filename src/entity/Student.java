package entity;

public class Student {

    private int idSudent;
    private int idGroup;
    private String fname;
    private String sname;
    private String lname;
    private String phone;

    public Student (){}

    public Student(int idStudent, int idGroup, String fname, String sname, String lname, String phone) {
        this.idSudent = idStudent;
        this.idGroup = idGroup;
        this.fname = fname;
        this.sname = sname;
        this.lname = lname;
        this.phone = phone;
    }

    public int getIdSudent() {
        return idSudent;
    }

    public void setIdSudent(int idSudent) {
        this.idSudent = idSudent;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
