package canvas.library.render;

import canvas.library.math.geometry.Point;

public interface Lines
{
    void drawLine(int x1, int y1, int x2, int y2);

    default void drawLine(Point start, int x, int y) {
        this.drawLine(start.x, start.y, x, y);
    }

    default void drawLine(int x, int y, Point end) {
        this.drawLine(x, y, end.x, end.y);
    }

    default void drawLine(Point start, Point end) {
        this.drawLine(start.x, start.y, end.x, end.y);
    }
}
