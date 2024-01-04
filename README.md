# 🌟 Java Swing User Authentication System

## 📌 Overview
This Java Swing-based application offers a robust **user authentication system**, integrating UI components with backend logic following an **MVC architecture**. It's designed for managing user registration and login processes efficiently.

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

## 🛠️ API Description

### `User.java`
- **Purpose**: Manages user properties and provides methods for data validation.
- **Functionality**: Includes password validation and integrity checks for user data.

### `FileHandler.java`
- **Purpose**: Handles operations related to file-based data storage.
- **Functionality**: Responsible for checking if a username exists and appending new user data to `userinfo.txt`.

### `Login.java`
- **Purpose**: Implements the logic for user login.
- **Functionality**: Validates user credentials by reading and comparing data from `userinfo.txt`.

### `Registration.java`
- **Purpose**: Handles the user registration process.
- **Functionality**: Validates registration inputs and appends new user information to `userinfo.txt` if valid.

### `LoginForm.java` & `RegistrationForm.java`
- **Purpose**: Provide the graphical interface for user login and registration.
- **Inheritance**: Derived from `BaseForm.java` for a consistent look and feel.

### `BaseForm.java`
- **Purpose**: Establishes a foundation for creating standardized Swing forms.
- **Functionality**: Includes methods for creating and arranging UI components.

### `MainGui.java` & `MainCli.java`
- **Purpose**: `MainGui.java` is the GUI entry point initializing the `LoginForm`, while `MainCli.java` may offer a command-line interface.

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
