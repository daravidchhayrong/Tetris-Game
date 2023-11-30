public class ZShape extends Shape{
    public ZShape() {
        // Initialize the shape matrix for the "Z" tetromino
        shapeMatrix = new char[][]{{'*','*',' '},{' ','*','*'}};
    }

    @Override
    public void drawShape() {
        for (short i = 0; i < shapeMatrix.length; i++) {
            for (short j = 0; j < shapeMatrix[i].length; j++) {
                System.out.print(shapeMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
