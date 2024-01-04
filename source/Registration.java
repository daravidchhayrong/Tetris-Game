import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registration {
    private FileHandler fileHandler;

    public Registration() {
        this.fileHandler = new FileHandler("userinfo.txt");
    }

    public boolean registerUser(String username, String password, String confirmPassword, boolean isAdminMode) {
        if (fileHandler.usernameExists(username)) {
            System.out.println("Error: Username already exists. Please choose a different username.");
            return false;
        }

        if (isInputValid(username, password, confirmPassword)) {
            createUserAndSave(username, password, isAdminMode);
        }
        return true;
    }

    private boolean isInputValid(String username, String password, String confirmPassword) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Error: Username cannot be empty.");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            System.out.println("Error: Password confirmation does not match.");
            return false;
        }
        User tempUserForValidation = new User(username, password, false); // false for isAdminMode
        if (!tempUserForValidation.isPasswordValid(password)) {
            System.out.println("Error: Password does not meet security requirements.");
            return false;
        }
        return true;
    }

    private void createUserAndSave(String username, String password, boolean isAdminMode) {
        try {
            User newUser = new User(username, password, isAdminMode);
            String userInfo = newUser.getUsername() + "," + newUser.getPassword() + "," + newUser.isAdmin();
            fileHandler.appendToFile(userInfo);
            System.out.println("User registered successfully: " + username);
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
        }
    }

    private static void testing() {
        Registration register = new Registration();
        register.registerUser("moni", "Moni123$", "Moni123$", false);
    }

    public static void main(String[] args) {
        testing();
    }
}
