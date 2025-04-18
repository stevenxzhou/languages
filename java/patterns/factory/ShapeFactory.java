package patterns.factory;

import java.security.InvalidParameterException;
import java.util.Scanner;

enum ShapeType {
    Circle,
    Square,
    Triangle,
    WrongShape
}

class ShapeFactory {

    public static Shape getShape(ShapeType shapeType, double...args) {
        switch (shapeType) {
            case Circle:
                return new Circle(args[0]);
            case Square:
                return new Square(args[0]);
            case Triangle:
                return new Triangle(args[0], args[1]);
            default:
                throw new InvalidParameterException("Wrong shape!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter shape type (Circle, Square, Triangle): ");
        String shapeType = scanner.nextLine();

        Shape shape = null;
        if (ShapeType.valueOf(shapeType) == ShapeType.Triangle) {
            System.out.print("Enter trianble base: ");
            double base = scanner.nextDouble();
            System.out.print("Enter trianble height: ");
            double height = scanner.nextDouble();
            shape = ShapeFactory.getShape(ShapeType.valueOf(shapeType), base, height);
        } else {
            System.out.print("Enter dimensions (e.g., radius for Circle or side for Square): ");
            double dimension = scanner.nextDouble();
            shape = ShapeFactory.getShape(ShapeType.valueOf(shapeType), dimension);
        }

        System.out.println("Shape: " + shape.getName());
        System.out.println("Area: " + shape.getArea());
    }
}