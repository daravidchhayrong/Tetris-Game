import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User{
    private String username;
    private String password;
    private boolean isAdminMode;

    public User(String username, String password, boolean mode) {
        this.username = username;
        this.password = hashPassword(password);
        this.isAdminMode = mode;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAdmin() {
        return this.isAdminMode;
    }

    public void setAdminMode(boolean newMode) {
        this.isAdminMode = newMode;
    }

    public void setPassword(String newPassword) {
        if(isPasswordValid(newPassword)) {
            this.password = hashPassword(newPassword);
        } else {
            System.out.println("ERROR: Password does not meet security requirements.");
        }
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(hashPassword(password));
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public boolean isPasswordValid(String password) {
        return hasStrongPasswordPolicy(password) && password.length() >= 8;
    }

    private boolean hasStrongPasswordPolicy(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialCharacter = password.matches(".*[!@#$%^&*+=-_?<>\\[\\]{}|].*");
        return hasUppercase && hasLowercase && hasNumber && hasSpecialCharacter && password.length() >= 8;
    }

    public String toString() {
        return "Username: " + this.username;
    }
}
