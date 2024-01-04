import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends BaseForm {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton loginButton, registerButton;

    @Override
    protected void initializeComponents() {
        usernameField = createTextField((short)300, (short)50);
        passwordField = createPasswordField((short)300, (short)50);
        showPassword = createCheckBox("Show Password", this::togglePasswordVisibility);
        loginButton = createButton("Login", this::performLogin);
        registerButton = createButton("Register", e -> openRegistrationForm());
    }

    @Override
    protected void layoutComponents() {
        addComponent(createTextLabel("Username: "));
        addComponent(usernameField);
        addComponent(createTextLabel("Password: "));
        addComponent(passwordField);
        addComponent(showPassword);
        addComponent(loginButton);
        addComponent(registerButton);
    }

    private void togglePasswordVisibility(ActionEvent e) {
        System.out.println("ACTION(LOGIN): Show Password Button CLICKED!");
        if (passwordField.getEchoChar() != '\0') {
            passwordField.setEchoChar('\0');
            System.out.println("Password Unhide");
        } else {
            passwordField.setEchoChar('●');
            System.out.println("Password Hide");
        }
    }

    private void performLogin(ActionEvent e) {
        System.out.println("ACTION(LOGIN): Login Button CLICKED!");
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("EMPTY username or password");
            JOptionPane.showMessageDialog(this, "Please enter both username and password");
        } else {
            Login login = new Login();
            if (login.loginUser(username, password)) {
                System.out.println("ACTION(LOGIN): Login Successful");
                JOptionPane.showMessageDialog(this, "Login successful");
                // Optionally, proceed to the next part of your application
            } else {
                System.out.println("ACTION(LOGIN): Login Failed");
                JOptionPane.showMessageDialog(this, "Login failed");
            }
        }
    }

    private void openRegistrationForm() {
        SwingUtilities.invokeLater(RegistrationForm::new);
        this.dispose();
    }
}

