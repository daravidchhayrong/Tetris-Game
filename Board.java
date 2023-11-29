public class Board {

    // Print the matrix
    static void printMatrix(char mat[][]) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Fill the matrix with initial values
    static void initialFill(char mat[][]) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (row == 0 || row == mat.length - 1 || col == 0 || col == mat[0].length - 1) {
                    mat[row][col] = '*'; // Set boundary cells as '*'
                } else {
                    mat[row][col] = ' '; // Set non-boundary cells as empty space
                }
            }
        }
    }
}