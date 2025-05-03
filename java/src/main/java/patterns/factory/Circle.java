package patterns.factory;

public class Circle implements Shape{
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14 * this.radius * this.radius;
    }

    @Override
    public String getName() {
        return "This is Circle";
    }
}
