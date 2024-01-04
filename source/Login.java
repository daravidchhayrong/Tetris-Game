public class Login {
    private FileHandler fileHandler;

    public Login() {
        this.fileHandler = new FileHandler("userinfo.txt");
    }

    public boolean loginUser(String username, String password) {
        String userData = fileHandler.readFile(); 

        String[] userLines = userData.split("\n");
        for (String userLine : userLines) {
            String[] userDetails = userLine.split(",");
            if (userDetails[0].equals(username) && userDetails[1].equals(User.hashPassword(password))) {
                // Login success
                return true;
            }
        }
        return false;
    }

     public boolean getIsAdmin(String username) {
        String userLine = fileHandler.getUserData(username);
        if (userLine != null) {
            String[] userDetails = userLine.split(",");
            if (userDetails.length > 2) {
                // Assuming the third element is the admin flag
                return Boolean.parseBoolean(userDetails[2]);
            }
        }
        return false; // Default to false if user not found or data is incomplete
    }

    private static void test() {
        Login login = new Login();
        boolean result = login.loginUser("moni", "Moni123$");
        System.out.println("Login " + (result ? "Successful" : "Failed"));
    }

    public static void main(String[] args) {
        test();
    }
}
