package canvas.library.math.geometry;

import canvas.library.resource.Color;

import java.util.Arrays;

public abstract class Shape implements Movable, Renderable
{
    //# Fields
    protected Point[] vertices;
    protected int[][] path;

    protected Color color = null;
    protected boolean filled = false;


    //# Constructors
    Shape(int points) {
        this.vertices = new Point[points];

        for (int i = 0; i < points; i ++) {
            this.vertices[i] = new Point(0, 0);
        }

        this.updateLinePath();
    }

    Shape(Point... vertices) {
        this.vertices = vertices;

        this.updateLinePath();
    }


    //# Getter-methods
    Color getColor() {
        return this.color;
    }

    boolean isFilled() {
        return this.filled;
    }

    Rectangle getBounds() {
        int[] x = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int[] y = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };

        for (Point point : this.vertices) {
            x[0] = Math.min(point.x, x[0]);
            y[0] = Math.min(point.y, y[0]);

            x[1] = Math.max(point.x, x[1]);
            y[1] = Math.max(point.y, y[1]);
        }

        return new Rectangle(
                x[0], y[0], x[1] - x[0], y[1] - y[0]
        );
    }


    //# Methods
    private void updateLinePath() {
        int n = this.vertices.length + (this.vertices.length > 2 ? 1 : 0);

        int[][] path = new int[][] { new int[n], new int [n] };

        for (int i = 0; i < n; i ++) {
            path[0][i] = this.vertices[i%this.vertices.length].x;
            path[1][i] = this.vertices[i%this.vertices.length].y;
        }

        this.path = path;
    }


    //# Overrides
    @Override
    public void move(int x, int y) {
        Arrays.stream(this.vertices).forEach(point -> point.move(x, y));

        this.updateLinePath();
    }


    //# Abstract
    abstract public void draw(java.awt.Graphics2D graphics);
}
