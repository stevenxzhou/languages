package patterns.factory;

public class Square implements Shape{

    private double side;

    public Square(double side){
        this.side = side;
    } 
    public double getArea() {
        return this.side * this.side;
    }

    public String getName() {
        return "This is a Square";
    }
}
