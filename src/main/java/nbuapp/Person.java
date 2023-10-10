package nbuapp;

public class Person {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int tblPerson;
    private int tblPersonId;
    private static int usernameId = 103;

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = String.valueOf(usernameId);
        generateUsername(firstName, lastName);
        usernameId++;
    }

    public Person() {};

    private void generateUsername(String firstName, String lastName) {
        this.userName = firstName.trim().charAt(0) + lastName.trim() + usernameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTblPerson() {
        return tblPerson;
    }

    public void setTblPerson(int tblPerson) {
        this.tblPerson = tblPerson;
    }

    public int getTblPersonId() {
        return tblPersonId;
    }

    public void setTblPersonId(int tblPersonId) {
        this.tblPersonId = tblPersonId;
    }

    @Override
    public String toString() {
        return "Person {" +
                "tblPersonId = " + getTblPersonId() +
                ", firstName = '" + getFirstName() + "'" +
                ", lastName = '" + getLastName() + "'" +
                ", username = '" + getUserName() + "'" +
                ", password = '" + getPassword() + "'" +
                "}";
    }
}
