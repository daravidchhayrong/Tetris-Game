import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends BaseForm {
    private JTextField usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JCheckBox showPassword;
    private JButton registerButton, gotoLoginButton;

    @Override
    protected void initializeComponents() {
        usernameField = createTextField((short)300, (short)50);
        passwordField = createPasswordField((short)300, (short)50);
        confirmPasswordField = createPasswordField((short)300, (short)50);
        showPassword = createCheckBox("Show Password", this::togglePasswordVisibility);
        registerButton = createButton("Register", this::performRegistration);
        gotoLoginButton = createButton("Go to Login", e -> openLoginForm());
    }

    @Override
    protected void layoutComponents() {
        addComponent(createTextLabel("Username: "));
        addComponent(usernameField);
        addComponent(createTextLabel("Password: "));
        addComponent(passwordField);
        addComponent(createTextLabel("Confirm Password: "));
        addComponent(confirmPasswordField);
        addComponent(showPassword);
        addComponent(registerButton);
        addComponent(gotoLoginButton);
    }

    private void togglePasswordVisibility(ActionEvent e) {
        System.out.println("ACTION(REGISTRATION): Show Password Button CLICKED!");
        char echoChar = (passwordField.getEchoChar() == '\0') ? '●' : '\0';
        System.out.println((echoChar == '\0') ? "Password Unhide" : "Password Hide");
        passwordField.setEchoChar(echoChar);
        confirmPasswordField.setEchoChar(echoChar);
    }

    private void performRegistration(ActionEvent e) {
        System.out.println("ACTION(REGISTRATION): Register Button CLICKED!");
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        // Implement registration logic here
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println("EMPTY username or password");
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Password NOT Match");
            JOptionPane.showMessageDialog(this, "Passwords do not match");
            return;
        }

        Registration registration = new Registration();
        boolean registrationSuccess = registration.registerUser(username, password, confirmPassword, false); // Assuming non-admin users for simplicity

        if (registrationSuccess) {
            System.out.println("Registration successful");
            JOptionPane.showMessageDialog(this, "Registration successful");
            MainGui.openLoginForm(); // Open login form after successful registration
            this.dispose(); // Close the registration form
        } else {
            System.out.println("Registration failed");
            JOptionPane.showMessageDialog(this, "Registration failed");
        }
    }

    private void openLoginForm() {
        SwingUtilities.invokeLater(LoginForm::new);
        this.dispose();
    }
}

