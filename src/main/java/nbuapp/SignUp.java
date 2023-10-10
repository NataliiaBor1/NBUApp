package nbuapp;

import nbuapp.database.DBUtils;

import java.util.List;
import java.util.Scanner;

public class SignUp {
    private void printWelcomeMessage() {
        System.out.println("               Welcome to NBU!");
        System.out.println();
    }

    private void signUp() {
        Admin admin = new Admin("Ivan", "Sidorov");
        Admin.addAdmin(admin);

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("Local Admins list");
        Admin.printAdmins();

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("DB Users list");
        List<Person> dBPersons = DBUtils.getTablePersonData();
        System.out.println(dBPersons);

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("DB Admins list");
        List<Admin> dbAdmins = DBUtils.getTableAdminData();
        System.out.println(dbAdmins);

        System.out.println();
        System.out.println("Enter 'Q' for quit");
        System.out.println();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter username: ");
        String input = in.nextLine();

        if (input.equals("Q") || input.equals("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }

        String username = input;

        System.out.println("Enter password :");
        input = in.nextLine();
        if (input.equals("Q") || input.equals("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }
        String password = input;

        checkCredentials(username, password);
    }

    private void checkCredentials(String username, String password) {
        List<Admin> adminsList = Admin.getAdmins();
        for (Admin admin: adminsList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "!");
                Admin.runAdmin();
            } else {
                System.out.println("Sorry, we can not recognize you. Check your credentials and try again later.");
                System.out.println("Goodbye");
                System.exit(0);
                return;
            }
        }
    }

    public void runNBUApp() {
        printWelcomeMessage();
        signUp();
    }
}
