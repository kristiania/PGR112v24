package solutions._09;

public class MovablePoint implements Movable
{
    private double x;
    private double y;

    public MovablePoint() {
        this(0, 0);
    }

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }


    //# Getter-methods
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }


    //# Setter-methods
    private void setX(double value) {
        this.x = value;
    }

    private void setY(double value) {
        this.y = value;
    }

    //# Methods
    @Override
    public void moveUp(double distance) {
        this.y += distance;
    }

    @Override
    public void moveDown(double distance) {
        this.y -= distance;
    }

    @Override
    public void moveLeft(double distance) {
        this.x -= distance;
    }

    @Override
    public void moveRight(double distance) {
        this.x += distance;
    }
}
