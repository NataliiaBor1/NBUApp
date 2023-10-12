package nbuapp;

import nbuapp.database.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person implements IPrintAdmin, IExit {

    private String id = "A";
    private static int adminId = 1000001;
    private int tblAdminId;
    private int tblAdminPersonId;
    public static List<Admin> admins = new ArrayList<>();
    private static int idAdmin = 1;

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        this.id = id + adminId;
        adminId++;
        this.tblAdminId = idAdmin;
        idAdmin++;
        this.tblAdminPersonId = getTblPersonId();
    }

    public Admin() {};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTblAdminId() {
        return tblAdminId;
    }

    public void setTblAdminId(int tblAdminId) {
        this.tblAdminId = tblAdminId;
    }

    public int getTblAdminPersonId() {
        return tblAdminPersonId;
    }

    public void setTblAdminPersonId(int tblAdminPersonId) {
        this.tblAdminPersonId = tblAdminPersonId;
    }

    @Override
    public String toString() {
        return "Admin {" +
                "tblAdminId = " + getTblAdminId() +
                ", tblPersonAdminId = " + getTblAdminPersonId() +
                ", tblPersonId = " + getTblPersonId() +
                ", firstName = '" + getFirstName() + "'" +
                ", lastName = '" + getLastName() + "'" +
                ", username = '" + getUserName() + "'" +
                ", password = '" + getPassword() + "'" +
                ", id = " + getId() +
                "}";
    }

    public static void addAdmin(Admin admin) {
        DBUtils.insertAdmin(admin);
        admins = DBUtils.getTableAdminData();
    }

    public static void printAdmins() {

        for (Admin admin : admins) {
            System.out.println(admin.getFirstName());
            System.out.println(admin.getLastName());
            System.out.println(admin.getPassword());
            System.out.println(admin.getUserName());
            System.out.println(admin.id);
        }
    }

    public static List<Admin> getAdmins() {
        return admins;
    }

    public void runAdmin() {
        printQForExit();

        Scanner in = new Scanner(System.in);

        System.out.println("Would you like");
        System.out.println("1 - Register new user");
        System.out.println("2 - Print existing data");

        String input = in.nextLine();

        switch (input) {
            case "Q", "q" -> {
                exitIfQ();
            }
            case "1" -> runRegistration();
            case "2" -> runPrintInformation();
        }

    }

    private void runRegistration() {
        System.out.println("Running registration");
        printQForExit();

        Scanner in = new Scanner(System.in);

        System.out.println("Would you like");
        System.out.println("1 - Register new Student");
        System.out.println("1 - Register new Professor");
        System.out.println("1 - Register new Admin");

        String input = in.nextLine();

        switch (input) {
            case "Q", "q" -> {
                exitIfQ();
            }
            case "1" -> runRegisterNewStudent();
            case "2" -> runRegisterNewProfessor();
            case "3" -> runRegisterNewAdmin();
        }

    }

    private void runPrintInformation() {
        System.out.println("Running Print information");
        printQForExit();
    }

    private void runRegisterNewStudent() {
        System.out.println("Register New Student");
        printQForExit();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter first name");
        String input = in.nextLine();
        exitIfQ();
        String firstName = input;

        System.out.println("Enter last name");
        input = in.nextLine();
        exitIfQ();
        String lastName = input;

    }

    private void runRegisterNewProfessor() {

    }

    private void runRegisterNewAdmin() {

    }

}


