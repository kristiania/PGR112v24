package solutions._09;

public class Rectangle extends Shape
{
    //# Fields
    private double width;
    private double height;
    private final MovablePoint[] corners;


    //# Constructors
    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        this(width, height, new MovablePoint(0, 0), new MovablePoint(width, height));
    }

    public Rectangle(double width, double height, MovablePoint upperLeftCorner, MovablePoint bottomRightCorner) {
        super();

        this.setWidth(width);
        this.setHeight(height);
        this.corners = new MovablePoint[]{ upperLeftCorner, bottomRightCorner };
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        this(width, height, new MovablePoint(0, 0), new MovablePoint(1, 1), color, filled);
    }

    public Rectangle(double width, double height, MovablePoint upperLeftCorner, MovablePoint bottomRightCorner, String color, boolean filled) {
        super(color, filled);

        this.setWidth(width);
        this.setHeight(height);
        this.corners = new MovablePoint[]{ upperLeftCorner, bottomRightCorner };
    }


    //# Getter-methods
    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    private MovablePoint[] getCorners() {
        return this.corners;
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
    public void moveUp(double distance) {
        this.corners[0].moveUp(distance);
        this.corners[1].moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        this.corners[0].moveDown(distance);
        this.corners[1].moveDown(distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.corners[0].moveLeft(distance);
        this.corners[1].moveLeft(distance);
    }

    @Override
    public void moveRight(double distance) {
        this.corners[0].moveRight(distance);
        this.corners[1].moveRight(distance);
    }

    @Override
    public String toString() {
        return String.format(
                "%s => Rectangle[width=%f; height=%f;]",
                super.toString(), this.getWidth(), this.getWidth()
        );
    }
}
