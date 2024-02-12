package solutions._09;

public class Circle extends Shape
{
    //# Fields
    private double radius;



    //# Constructors
    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        super();

        this.setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);

        this.setRadius(radius);
    }


    //# Getter-methods
    public double getRadius() {
        return this.radius;
    }


    //# Setter-methods
    protected void setRadius(double value) {
        this.radius = value;
    }


    //# Methods
    @Override
    public double getArea() {
        return (2*radius)*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*this.getRadius();
    }

    @Override
    public String toString() {
        return String.format(
                "%s => Circle[radius=%f;]",
                super.toString(), this.getRadius()
        );
    }
}