## Explanation Documentation: `Login.java`

### Overview
The `Login` class in the Java Swing User Authentication System is crucial for the authentication process. It manages the verification of user credentials against stored data.

### Key Features & Demonstrated Programming Concepts

#### Classes & Objects
- **Class Structure**: `Login` class is structured to handle the login process, with a private `FileHandler` to manage data interaction.
- **Object Utilization**: An instance of `Login` is created and used whenever a user attempts to log in, demonstrating the practical use of objects in managing application state.

#### Encapsulation
- **Private Data Handling**: The class utilizes a private `FileHandler` object, encapsulating the file reading logic within the class and preventing direct access from outside.
- **Public Interface**: Provides a public method `loginUser` allowing other parts of the application to initiate the login process without exposing internal details.

#### File I/O
- **Data Reading**: The class uses file I/O operations to read user data from a file (`userinfo.txt`), which is crucial for validating user credentials.

#### Exception Handling
- The class is designed to handle exceptions related to file operations, ensuring the application remains stable in case of I/O errors.

#### Static Methods
- **Static Method Usage**: Utilizes static methods from the `User` class (e.g., `User.hashPassword`) for operations like password hashing, which are independent of the instance state of `Login`.

---


