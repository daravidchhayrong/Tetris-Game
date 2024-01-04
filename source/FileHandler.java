import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    private void handleIOException(IOException e, String message) {
        System.err.println(message + ": " + e.getMessage());
    }

    private boolean isFileExists() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                handleIOException(e, "Error creating new file");
                return false;
            }
        }
        return true;
    }

    public void appendToFile(String content) {
        if (isFileExists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(content);
                writer.newLine();
            } catch (IOException e) {
                handleIOException(e, "Error writing to file");
            }
        }
    }

    public String readFile() {
        if (!isFileExists()) {
            System.err.println("File does not exist: " + filePath);
            return "";
        }

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            handleIOException(e, "Error reading from file");
            return "";
        }
        return contentBuilder.toString();
    }

    public boolean usernameExists(String username) {
        String userData = readFile();
        String[] userLines = userData.split("\n");
        for (String userLine : userLines) {
            String[] userDetails = userLine.split(",");
            if (userDetails[0].equals(username)) {
                return true;
            }
        }
        return false;
    }

    public String getUserData(String username) {
        String userData = readFile();
        String[] userLines = userData.split("\n");
        for (String userLine : userLines) {
            String[] userDetails = userLine.split(",");
            if (userDetails.length > 0 && userDetails[0].equals(username)) {
                return userLine; // Return the line corresponding to the user
            }
        }
        return null; // User not found
    }

}
