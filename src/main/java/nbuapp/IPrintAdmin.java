package nbuapp;

import static nbuapp.Admin.admins;
import static nbuapp.Student.students;

public interface IPrintAdmin {

    default void printAdminsList() {
        System.out.println(admins);
    }

    default void printStudentsList() {
        System.out.println(students);
    }
}
