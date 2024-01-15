# 🌟 Java Swing User Authentication System

## 📌 Overview

This Java Swing-based application offers a robust **user authentication system**,
integrating UI components with backend logic following an **MVC architecture**. It's designed for
managing user registration and login processes efficiently.

---

## 🚀 Usage

### 🔧 Setup

- Ensure the **Java Development Kit (JDK)** is installed.
- Compile the Java files in the `src` directory.
- Run `MainGui.java` to launch the application.

### ▶️ Running the Application

Start the application by executing `MainGui.java`, which opens the login form, the primary interface for user authentication.

### 🧭 Navigation

- **Login Page**: 🚪 Enter credentials to access the application.
- **Registration Page**: 📝 Sign up for a new account via the registration form.

### 🚪 Exiting the Application

Close the main window to safely exit the application.

---

# Demonstrated Object Oriented Concepts

## **Polymorphism**

Before initializing a form components such as LoginForm or RegistrationForm , the client must first create a BaseForm that
can render the UI components such as button, form fields and text labels. The initial class of "BaseForm" can then be morphed into different
type of classes depending on the implementation of abstract methods `initializeComponents()` and `layoutComponents()`.


## **Abstraction**

-  `BaseForm` is defined as an abstract class, meaning it cannot be instantiated on its own but provides a template for other forms. while it have the essential components such as the font configs UI components builder and also the capability to render UI since it inherit "JFrame", it does
not have enough information to create a new form. Things such as the layout configs and what kind of fields should be put in must be defined in the class that it inherits.

```java
public abstract class BaseForm extends JFrame {
    protected Font font = new Font("Arial", Font.PLAIN, 30);
    protected GridBagConstraints gbc = new GridBagConstraints();

    public BaseForm() {
        setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(13, 40, 13, 40);

        initializeComponents();
        layoutComponents();
        configureFrame();
    }

    protected abstract void initializeComponents();
    protected abstract void layoutComponents();

```

- **Common Functionality**: It defines common functionalities and layouts that other forms (like `LoginForm` and `RegistrationForm`) can inherit and use.

## **Inheritance**

Inheritance allow the creation of subsclasses which inherit behavoirs and properties from their parents.
- **Inherits from `JFrame`**:
`BaseForm` extends the `JFrame` class from Swing, inheriting its properties and methods suitable for creating window-based
gui.

## **Encapsulation**

- public : can be accessed by any other class and package. This is only used by a handful of methods and fields to expose certain functionality for other packages
or class to use.

```java
    public MainCli() {
        this.register = new Registration();
        this.login = new Login();
        this.scanner = new Scanner(System.in);
    }
```

- private : can only be accessible within the same class and not visible to subsclasses or other classes. private fields are used on most of the fields
because we don't want them to be modified by external environment.

```java
    private JTextField usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JCheckBox showPassword;
    private JButton registerButton, gotoLoginButton;
```

## **Exception Handling**

- **Robust GUI Creation**: While specific exception handling is not detailed in the provided snippet, Swing components inherently include
mechanisms to handle UI exceptions.

- **File IO error handling** : while creating a new file , the client need to handle the exceptions caused by external factors beyond the programmer controls
or in short the error that will happen during the application runtime. One of such instance is the Input Ouput exception which is usually thrown during while
application perform read or write operations. It usually occurs during :
    - File not found
    - Permission issues
    - Unexpected disruptions during file handling

```java
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
```
Another class method that allow  hash the password also need to handle exceptions. because the API provided by the java security modules require the user to input the type of algorithm that will be used for hashing.
In case the algorithm name is not supported by the module list it will through the exception of "NoSuchAlgorithmException".

```java
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash); } catch (NoSuchAlgorithmException e) { throw new RuntimeException("Error hashing password", e); }
    }

```
---


# 🛠️ API Description

### [User.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/User.java)

- **Purpose**: Manages user properties and provides methods for data validation.
- **Functionality**: Includes password validation and integrity checks for user data.

### [FileHandler.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/FileHandler.java)

- **Purpose**: Handles operations related to file-based data storage.
- **Functionality**: Responsible for checking if a username exists and appending new user data to `userinfo.txt`.

### [Login.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/Login.java)

- **Purpose**: Implements the logic for user login.
- **Functionality**: Validates user credentials by reading and comparing data from `userinfo.txt`.

### [Registration.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/Registration.java)

- **Purpose**: Handles the user registration process.
- **Functionality**: Validates registration inputs and appends new user information to `userinfo.txt` if valid.

### [LoginForm.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/LoginForm.java) & [RegistrationForm.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/RegistrationForm.java)

- **Purpose**: Provide the graphical interface for user login and registration.
- **Inheritance**: Derived from `BaseForm.java` for a consistent look and feel.

### [BaseForm.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/BaseForm.java)

- **Purpose**: Establishes a foundation for creating standardized Swing forms.
- **Functionality**: Includes methods for creating and arranging UI components.

### [Board.java](https://github.com/FxoMark/Tetris-Game/blob/main/Board.java)

- **Purpose**: Create the board
- **Functionality**: Create a pattern for the board and then print out the board

### [Shape.java](https://github.com/FxoMark/Tetris-Game/blob/main/Shape.java)

- **Purpose**: Create the shape as the parent
- **Functionality**: This shape is an abstract class that act as a parent which is used to be converted to a different type of shape such as
L shape, T shape, I Shape , etc.

### [MainGui.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/MainGui.java) & [MainCli.java](https://github.com/FxoMark/Tetris-Game/blob/main/source/MainCli.java)

- **Purpose**: `MainGui.java` is the GUI entry point initializing the `LoginForm`, while `MainCli.java` may offer a command-line interface.
- **Functionality**: Both class provide functionalities for application to be run in either GUI or CLI mode. The main gui and cli entrypoint is the `LoginForm`.

---

## 📝 Additional Notes

- **Data Storage**: Uses `userinfo.txt` for storing user credentials and data.
- **Password Handling**: Enhancements recommended for password encryption and security.
- **Thread Safety**: Complies with the Swing threading model for safe UI operations.

---

## ⏭️ Future Enhancements

- **Security**: Advance password security with hashing and encryption.
- **UI Experience**: Further refine the UI for a more engaging user experience.
- **Feature Addition**: Consider adding password recovery, user profile management, and admin features.

---

## 📜 License

### MIT License

Copyright (c) [2024]

---
