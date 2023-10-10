package nbuapp;

import nbuapp.database.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Person {

    private String id = "A";
    private static int adminId = 1000001;
    private int tblAdminId;
    private int tblAdminPersonId;
    private static List<Admin> admins = new ArrayList<>();
    private static int idAdmin = 1;

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        this.id = id + adminId;
        adminId++;
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
        admins.add(admin);
        DBUtils.createAdmin(admin);
    }

    public static void printAdmins() {

        for (Admin admin : admins) {
            System.out.println(admin.getFirstName());
            System.out.println(admin.getLastName());
            System.out.println(admin.getPassword());
            System.out.println(admin.getUsername());
            System.out.println(admin.id);
        }
    }

    public static List<Admin> getAdmins() {
        return admins;
    }

    public static void runAdmin() {

    }

}


