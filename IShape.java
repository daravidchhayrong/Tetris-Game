public class IShape extends Shape {
    public IShape() {
        // Initialize the shape matrix for the "I" tetromino
        shapeMatrix = new char[][]{{'*'}, {'*'}, {'*'}};
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