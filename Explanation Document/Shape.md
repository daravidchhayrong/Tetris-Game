## Explanation Documentation: `Shape.java`

### Overview

The `Shape.java` class is an abstract class serving as the base for various geometric shapes in a game or graphical application. It includes a `shapeMatrix` field to represent the matrix form of the shape and an abstract method `drawShape()` that must be implemented by its subclasses.

### Key Features

1. **`shapeMatrix` Field:**
   * Represents the matrix form of the specific shape.
2. **`getShapeMatrix()` Method:**
   * Returns the shape matrix for the specific shape.
3. **`drawShape()` Method (Abstract):**
   * Each subclass must provide its own implementation of this method, specifying how the shape should be drawn.

### Usage

1. **Inheritance:**
   * Extend the `Shape` class to create specific shapes by implementing the `drawShape()` method.
2. **Access Shape Matrix:**
   * Use the `getShapeMatrix()` method to retrieve the matrix representation of a specific shape.
