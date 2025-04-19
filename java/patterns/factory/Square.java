package patterns.factory;

public class Square implements Shape{

    private double side;

    public Square(double side){
        this.side = side;
    } 

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public String getName() {
        return "This is a Square";
    }
}
