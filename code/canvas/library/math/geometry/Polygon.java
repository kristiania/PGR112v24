package canvas.library.math.geometry;

import java.awt.*;

public class Polygon extends Shape
{
    //# Constructors
    Polygon(int vertices) {
        super(vertices);
    }

    Polygon(Point... vertices) {
        super(vertices);
    }


    //# Overrides
    @Override
    public void draw(Graphics2D graphics) {
        if (super.isFilled()) {
            graphics.drawPolygon(this.path[0], this.path[1], this.vertices.length + 1);
        }
        else {
            graphics.drawPolyline(this.path[0], this.path[0], this.vertices.length + 1);
        }
    }
}
