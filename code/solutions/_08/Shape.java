package solutions._08;

public abstract class Shape
{
    //# Static fields
    private static int counter = 0;

    //# Fields
    private final int id;
    private String color;
    private boolean filled;


    //# Constructors
    public Shape() {
        this("red", true);
    }

    public Shape(String color, boolean filled) {
        this.setColor(color);
        this.setFilled(filled);

        this.id = Shape.counter ++;
    }

    //# Getter-methods
    public int getID() {
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public boolean isFilled() {
        return this.filled;
    }


    //# Setter-methods
    private void setColor(String value) {
        this.color = value;
    }

    private void setFilled(boolean value) {
        this.filled = value;
    }


    //# Methods
    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape[id=%d; color=%s;  filled=%b;]".formatted(
                this.getID(),
                this.getColor(),
                this.isFilled()
        );
    }
}