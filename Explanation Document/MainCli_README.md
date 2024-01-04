## Explanation Documentation: `MainCli.java`

### Overview
`MainCli.java` serves as a command-line interface (CLI) counterpart to the graphical user interface (GUI) of our Java Swing User Authentication System. It allows users to interact with the application through a text-based menu, handling user registration and login processes via the command line.

### Key Features & Demonstrated Programming Concepts

#### Classes & Objects
- **Class Structure**: `MainCli` is structured to provide a CLI for user interactions.
- **Object Usage**: It creates instances of `Registration` and `Login` to facilitate the respective functionalities, demonstrating object-oriented programming.

#### Encapsulation
- **Private Members**: The class encapsulates its dependencies (`Registration`, `Login`, `Scanner`) as private members, controlling access to these objects.
- **Public Methods**: Offers public methods to start the CLI and handle user inputs, encapsulating the logic of user interactions.

#### Exception Handling
- **Input Handling**: Incorporates basic exception handling for user inputs, ensuring robust and error-tolerant operations in the CLI environment.

#### File I/O
- **Indirect File Interaction**: While `MainCli` itself does not directly perform file I/O, it utilizes `Registration` and `Login` classes which handle file-related operations.

#### Static Methods
- **Entry Point**: The `main` method in `MainCli` is a static method, serving as the entry point for running the CLI version of the application.

---


