package nbuapp;

public interface IExit {

    default void printQForExit() {
        System.out.println();
        System.out.println("Enter 'Q' for quit");
        System.out.println();
    }

    default void exitIfQ(String input) {
        if (input.equalsIgnoreCase("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }
    }

    default void exitIfQ() {
        System.out.println("Goodbye");
        System.exit(0);
    }

    default void exitIfAuthorizedUser() {
        System.out.println("Sorry, we can not recognize you");
        System.exit(0);
    }

}
