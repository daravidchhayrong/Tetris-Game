import java.util.Scanner;

public class MainCli {
    private final Registration register;
    private final Login login;
    private final Scanner scanner;

    public MainCli() {
        this.register = new Registration();
        this.login = new Login();
        this.scanner = new Scanner(System.in);
    }

    private int showMainMenu() {
        System.out.println("\n1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void handleRegistration() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.next();
        System.out.print("Is admin (true/false): ");
        boolean isAdmin = scanner.nextBoolean();

        register.registerUser(username, password, confirmPassword, isAdmin);
    }

    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (login.loginUser(username, password)) {
            System.out.println("Login successful!");
            afterLoginPanel(username);
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }

    private void checkUserRole(String username) {
        boolean isAdmin = login.getIsAdmin(username); // Ensure getIsAdmin method is implemented
        if (isAdmin) {
            System.out.println("You are logged in as Admin.");
        } else {
            System.out.println("You are logged in as a Normal User.");
        }
    }

    private void afterLoginPanel(String username) {
        while (true) {
            System.out.println("\n1. Check Role");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                checkUserRole(username);
            } else if (choice == 2) {
                System.out.println("Exiting user panel...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void run() {
        while (true) {
            switch (showMainMenu()) {
                case 1:
                    handleRegistration();
                    break;
                case 2:
                    handleLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }

    public static void main(String[] args) {
        MainCli app = new MainCli();
        app.run();
    }
}
