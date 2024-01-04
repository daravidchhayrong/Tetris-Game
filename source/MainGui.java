import javax.swing.SwingUtilities;

public class MainGui {
    private static LoginForm loginForm;  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGui::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        openLoginForm();
    }

    public static void openLoginForm() {
        if (loginForm == null || !loginForm.isDisplayable()) {
            loginForm = new LoginForm();  // Create a new instance if null or not displayable
            loginForm.setTitle("Login Page");
        } else {
            loginForm.toFront();  // Bring to front if already existing and displayable
        }
    }
}

