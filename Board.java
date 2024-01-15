public class Board {

    static void initialFill(char mat[][]) {
        for (short row = 0; row < mat.length; row++) {
            for (short col = 0; col < mat[0].length; col++) {
                if (row == 0 || row == mat.length - 1 || col == 0 || col == mat[0].length - 1) {
                    mat[row][col] = '*'; // Set boundary cells as '*'
                } else {
                    mat[row][col] = ' '; // Set non-boundary cells as empty space
                }
            }
        }
    }
    // Print the matrix
    static void printMatrix(char mat[][]) {
        for (short row = 0; row < mat.length; row++) {
            for (short col = 0; col < mat[0].length; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Fill the matrix with initial values
    

    // // Render the shape on the game board matrix
    // static void renderShape(char[][] matrix, char[][] shapeMatrix) {
    //     int shapeRows = shapeMatrix.length;
    //     int shapeCols = shapeMatrix[0].length;

    //     int boardRows = matrix.length;
    //     int boardCols = matrix[0].length;

    //     // Find the starting position for rendering the shape
    //     int startRow = (boardRows - shapeRows) / 2;
    //     int startCol = (boardCols - shapeCols) / 2;

    //     // Render the shape on the game board matrix
    //     for (int row = 0; row < shapeRows; row++) {
    //         for (int col = 0; col < shapeCols; col++) {
    //             if (shapeMatrix[row][col] != ' ') {
    //                 matrix[startRow + row][startCol + col] = shapeMatrix[row][col];
    //             }
    //         }
    //     }
    // }
}