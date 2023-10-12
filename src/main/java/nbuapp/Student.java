package nbuapp;

import nbuapp.database.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class Student extends Academic {

    private String id = "S";
    private static int studentID = 1000001;
    private int tblStudentId;
    private int tblStudentPersonId;
    private int tblStudentAcademicId;
    public static List<Student> students = new ArrayList<>();
    private static int idStudent = 1;



    public Student(String firstName, String lastName, List<String> courses) {
        super(firstName, lastName, courses);
        this.id = id + studentID;
        studentID++;
        this.tblStudentPersonId = getTblPersonId();
        this.tblStudentAcademicId = getTblAcademicId();
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName, new ArrayList<>());
        this.id = id + studentID;
        studentID++;
        this.tblStudentPersonId = getTblPersonId();
        this.tblStudentAcademicId = getTblAcademicId();
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student {" +
                "tblStudentId = " + getTblStudentId() +
                ", tblStudentPersonId = " + getTblStudentPersonId() +
                ", tblStudentAcademicId = " + getTblStudentAcademicId() +
                ", tblPersonId = " + getTblPersonId() +
                ", firstName = '" + getFirstName() + "'" +
                ", lastName = '" + getLastName() + "'" +
                ", username = '" + getUserName() + "'" +
                ", password = '" + getPassword() + "'" +
                ", tblAcademicId = '" + getTblAcademicId() + "'" +
                ", course1 = '" + getCourse1() + "'" +
                ", course2 = '" + getCourse2() + "'" +
                ", course3 = '" + getCourse3() + "'" +
                ", course4 = '" + getCourse4() + "'" +
                ", course5 = '" + getCourse5() + "'" +
                ", course6 = '" + getCourse6() + "'" +
                ", id = " + getId() +
                "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getStudentID() {
        return studentID;
    }

    public static void setStudentID(int studentID) {
        Student.studentID = studentID;
    }

    public int getTblStudentId() {
        return tblStudentId;
    }

    public void setTblStudentId(int tblStudentId) {
        this.tblStudentId = tblStudentId;
    }

    public int getTblStudentPersonId() {
        return tblStudentPersonId;
    }

    public void setTblStudentPersonId(int tblStudentPersonId) {
        this.tblStudentPersonId = tblStudentPersonId;
    }

    public int getTblStudentAcademicId() {
        return tblStudentAcademicId;
    }

    public void setTblStudentAcademicId(int tblStudentAcademicId) {
        this.tblStudentAcademicId = tblStudentAcademicId;
    }

    public static void addStudent (Student student) {
        DBUtils.insertStudent(student);
        students = DBUtils.getTableStudentData();
    }
}
