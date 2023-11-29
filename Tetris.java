import java.util.Random;

public class Tetris {
    // Generate a random number between 0 and 5
    static int generateRandomNumber() {
        int num = new Random().nextInt(6);
        return num;
    }

    public static void main(String[] args) {
        // Create a 2D array to represent the game board matrix
        char matrix[][] = new char[18][10];
        
        // Fill the matrix with initial values
        Board.initialFill(matrix);
        
        // Print the initial game board matrix
        Board.printMatrix(matrix);

        while (true) {
            // Array of shape names
            String shapes[] = {"S", "L", "T", "SQ", "Z", "I"};
            
            // Select a random shape name from the array
            String ch = shapes[generateRandomNumber()];
            
            // Declare a variable to hold the shape object
            Shape shape;

            // Create an instance of the selected shape based on the shape name
            switch (ch) {
                case "S":
                    shape = new SShape();
                    break;
                case "L":
                    shape = new LShape();
                    break;
                case "T":
                    shape = new TShape();
                    break;
                case "SQ":
                    shape = new SquareShape();
                    break;
                case "Z":
                    shape = new ZShape();
                    break;
                case "I":
                    shape = new IShape();
                    break;
                default:
                    shape = null;
            }

            // Get the shape matrix for the selected shape
            char[][] shapeMatrixes = shape.getShapeMatrix();
            
            // Uncomment the code below to print the shape matrix
            // for (int i = 0; i < shapeMatrixes.length; i++) {
            //     for (int j = 0; j < shapeMatrixes[i].length; j++) {
            //         System.out.print(shapeMatrixes[i][j]);
            //     }
            //     System.out.println();
            // }
        }
    }
}

