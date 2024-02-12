package solutions._09;

public class Circle extends Shape
{
    //# Fields
    private double radius;
    private MovablePoint center;


    //# Constructors
    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this(radius, new MovablePoint(0.0, 0.0));
    }

    public Circle(double radius, MovablePoint center) {
        super();

        this.setRadius(radius);
        this.setCenterPoint(center);
    }

    public Circle(double radius, String color, boolean filled) {
        this(radius, new MovablePoint(0.0, 0.0), color, filled);
    }

    public Circle(double radius, MovablePoint center, String color, boolean filled) {
        super(color, filled);

        this.setRadius(radius);
        this.setCenterPoint(center);
    }


    //# Getter-methods
    public double getRadius() {
        return this.radius;
    }

    private MovablePoint getCenterPoint() {
        return this.center;
    }


    //# Setter-methods
    public void setRadius(double value) {
        this.radius = value;
    }

    private void setCenterPoint(MovablePoint value) {
        this.center = value;
    }


    //# Unique-method
    public void uniqueCircleMethod() {
        System.out.println("Dette er en sirkel");
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
    public void moveUp(double distance) {
        this.getCenterPoint().moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        this.getCenterPoint().moveDown(distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.getCenterPoint().moveLeft(distance);
    }

    @Override
    public void moveRight(double distance) {
        this.getCenterPoint().moveRight(distance);
    }

    @Override
    public String toString() {
        return String.format(
                "%s => Circle[radius=%f;]",
                super.toString(), this.getRadius()
        );
    }
}