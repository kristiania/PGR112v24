package solutions._09;

public class Square extends Rectangle
{
    //# Constructors
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, MovablePoint upperLeftCorner, MovablePoint bottomRightCorner) {
        super(side, side, upperLeftCorner, bottomRightCorner);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(double side, MovablePoint upperLeftCorner, MovablePoint bottomRightCorner, String color, boolean filled) {
        super(side, side, upperLeftCorner, bottomRightCorner, color, filled);
    }


    //# Getter-methods
    public double getSide() {
        return this.getWidth();
    }


    //# Setter-methods
    private void setSide(double side) {
        this.setWidth(side);
        this.setHeight(side);
    }


    //# Methods
    @Override
    public String toString() {
        return super.toString()
                .replaceFirst("Rectangle", "Rectangle => Square")
                .replaceFirst("width", "side")
                .replaceFirst("height", "side");
    }
}

