package solutions._09;


public abstract class Shape
{
    //# Static fields
    private static int counter = 0;


    //# Fields
    private final int id;
    private String color;
    private boolean filled;


    //# Constructor
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

    public boolean getFilled() {
        return this.filled;
    }


    //# Setter-methods
    protected void setColor(String value) {
        this.color = value;
    }

    protected void setFilled(boolean value) {
        this.filled = value;
    }


    //# Methods
    @Override
    public String toString() {
        return String.format("Shape[color=%s; filled=%s;]", this.getColor(), this.getFilled());
    }


    //# Abstracts
    abstract public double getArea();
    abstract public double getPerimeter();
}

