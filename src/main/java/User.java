
public class User {

    private String name;
    private String lastName;
    private String phoneNumber;
    private String password;
    private int userID;

    public User(String name, String lastName, String phoneNumber, String password, int userID) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userID = userID;
    }

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
