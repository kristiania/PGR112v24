package solutions._08;

public class Square extends Rectangle
{
    //# Konstruktører
    public Square() {
        this(1.0);
    }

    public Square(double side) {
        super(side, side);
    }


    //# Getter-metoder
    public double getSide() {
        return super.getWidth(); // kunne vært .getHeight() også, bredde og høyde er lik!
    }


    //# Setter-metoder
    private void setSide(double value) {
        this.setWidth(value);
        this.setHeight(value);
    }
}