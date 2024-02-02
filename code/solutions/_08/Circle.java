package solutions._08;

public class Circle extends Shape
{
    //# Felter
    private double radius;

    //# Konstruktører
    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        super();

        this.setRadius(radius);
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);

        this.setRadius(radius);
    }

    //# Getter-metoder
    public double getRadius() {
        return this.radius;
    }

    //# Setter-metoder
    private void setRadius(double value) {
        this.radius = value;
    }

    //# Metoder
    // Regn ut areal
    public double getArea() {
        return 0.0;
    }

    // Regn ut omkrets
    public double getPerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Circle[radius=%.2f;]%n - %s".formatted(
                this.getRadius(),
                super.toString()
        );
    }
}