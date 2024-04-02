package canvas.library.math.geometry;


public class Point extends java.awt.Point implements Movable
{
    //# Constructors
    public Point() {
        super(0, 0);
    }

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        this.moveX(x);
        this.moveY(y);
    }

    public void moveX(int x) {
        this.x += x;
    }

    public void moveY(int y) {
        this.y += y;
    }

    static public Point valueOf(java.awt.Point object) {
        return new Point(object.x, object.y);
    }
}
