package nbuapp;

import nbuapp.database.DBUtils;

import java.util.List;
import java.util.Scanner;

import static nbuapp.Admin.admins;

public class SignUp implements IExit {
    private void printWelcomeMessage() {
        System.out.println("               Welcome to NBU!");
        System.out.println();
    }

    private void signUp() {
        admins = DBUtils.getTableAdminData();

        if (admins.size() == 0) {
            Admin admin = new Admin("Ivan", "Sidorov");
            Admin.addAdmin(admin);
        }

        admins.get(0).printAdminsList();

        printQForExit();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter username: ");
        String input = in.nextLine();

        exitIfQ(input);

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
            if (admin.getUserName().equals(username) && admin.getPassword().equals(password)) {
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
