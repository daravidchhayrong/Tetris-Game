## Explanation Documentation: `User.java`

### Overview
`User.java` is a fundamental class in the Java Swing User Authentication System, representing users within the application. It encapsulates user attributes and provides methods related to user data management.

### Key Features & Demonstrated Programming Concepts

#### Classes & Objects
- **Class Definition**: `User` class is defined with properties such as `username`, `password`, and `isAdminMode`.
- **Object Usage**: Instances of `User` are created for handling user data throughout the application.

#### Encapsulation
- **Private Fields**: User details are encapsulated as private attributes (`username`, `password`, `isAdminMode`) to restrict direct access.
- **Public Methods**: Provides public methods like `getUsername()` and `setUsername()` for controlled data access and modification.

#### Exception Handling
- **NoSuchAlgorithmException Handling**: In the `hashPassword` method, exception handling is implemented to manage potential cryptographic algorithm errors.

#### File I/O
- While not directly handling file operations in `User.java`, the class is designed to be compatible with file-based data storage systems used elsewhere in the application.

#### Static Methods
- **Password Hashing**: Utilizes a static method, `hashPassword`, for converting plain text passwords into a hashed format.

---


