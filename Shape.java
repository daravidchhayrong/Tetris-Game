abstract class Shape {
    public char[][] shapeMatrix;

    // Returns the shape matrix for the specific shape
    public char[][] getShapeMatrix() {
        return shapeMatrix;
    }

    public abstract void drawShape();
    

    // Each subclass will provide its own implementation
    // of this method
   
}