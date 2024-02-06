package tasks._09.code;

public class Rectangle extends Shape
{
    //# Fields
    private double width;
    private double height;


    //# Constructors
    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        super();

        this.setWidth(width);
        this.setHeight(height);
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);

        this.setWidth(width);
        this.setHeight(height);
    }


    //# Getter-methods
    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }


    //# Setter-methods
    protected void setWidth(double value) {
        this.width = value;
    }

    protected void setHeight(double value) {
        this.height = value;
    }


    //# Methods
    @Override
    public double getArea() {
        return this.getWidth()*this.getHeight();
    }

    @Override
    public double getPerimeter() {
        return 2*(this.getWidth() + this.getHeight());
    }

    @Override
    public String toString() {
        return String.format(
                "%s => Rectangle[width=%f; height=%f;]",
                super.toString(), this.getWidth(), this.getWidth()
        );
    }
}
