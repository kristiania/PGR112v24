package tasks._09.code;


public abstract class Shape
{
    //# Fields
    private String color;
    private boolean filled;


    //# Constructor
    public Shape() {
        this("red", true);
    }

    public Shape(String color, boolean filled) {
        this.setColor(color);
        this.setFilled(filled);
    }


    //# Getter-methods
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

