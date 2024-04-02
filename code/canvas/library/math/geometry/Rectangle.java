package canvas.library.math.geometry;

import java.awt.*;
import java.awt.Dimension;

public class Rectangle extends java.awt.Rectangle implements Renderable
{
    //# Fields
    private Polygon shape;


    //# Constructors
    public Rectangle() {
        super();
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.createShape();
    }

    public Rectangle(int width, int height) {
        super(0, 0, width, height);
        this.createShape();
    }

    public Rectangle(Point point, Dimension size) {
        super(point.x, point.y, size.width, size.height);
        this.createShape();
    }

    public Rectangle(Point point) {
        super(point.x, point.y, 0, 0);
        this.createShape();
    }

    public Rectangle(Dimension size) {
        super(0, 0, size.width, size.height);
        this.createShape();
    }


    //# Helper-methods
    private void createShape() {
        this.shape = new Polygon(
                new Point(super.x, super.y),
                new Point(super.x + super.width, super.y),
                new Point(super.x + super.width, super.y + super.height),
                new Point(super.x, super.y + super.height)
        );
    }


    //# Getter-methods
    Polygon getShape() {
        return this.shape;
    }


    //# Methods
    public void draw(Graphics2D graphics) {
        if (this.shape.isFilled()) {
            graphics.fillRect(this.x, this.y, this.width, this.height);
        }
        else {
            graphics.drawRect(this.x, this.y, this.width, this.height);
        }
    }
}
