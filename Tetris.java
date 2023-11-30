import java.util.Random;

public class Tetris {
    // Create a shared instance of Random
    static Random random = new Random();
    static int previousNumber = -1;

    // Generate a random number between 0 and 5 (inclusive) that is different from the previous number
    static int generateRandomNumber() {
        int num;
        do {
            num = random.nextInt(6);
        } while (num == previousNumber);
        
        previousNumber = num;
        return num;
    }

    public static void main(String[] args) {
        final short MATRIX_ROW = 18;
        final short MATRIX_COLUMN = 10;
        // Create a 2D array to represent the game board matrix
        char matrix[][] = new char[MATRIX_ROW][MATRIX_COLUMN];
        
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
            char[][] shapeMatrix = shape.getShapeMatrix();

            // // Render the shape on the game board matrix
            // Board.renderShape(matrix, shapeMatrix);

            // // Print the updated game board matrix
            // Board.printMatrix(matrix);
            

            // try {
            //     Thread.sleep(200);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }


            
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

