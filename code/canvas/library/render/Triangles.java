package canvas.library.render;

import canvas.library.math.geometry.Point;

import java.util.ArrayList;

public interface Triangles
{
    void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3);

    default void drawTriangle(Point A, Point B, Point C) {
        this.drawTriangle(A.x, A.y, B.x, B.y, C.x, C.y);
    }

    default void drawTriangle(Point... points) {
        assert points.length >= 3;

        this.drawTriangle(
                points[0].x, points[0].y,
                points[1].x, points[1].y,
                points[2].x, points[2].y
        );
    }

    default void drawTriangle(ArrayList<Point> points) {
        assert points.size() >= 3;

        this.drawTriangle(
                points.get(0).x, points.get(0).y,
                points.get(1).x, points.get(1).y,
                points.get(2).x, points.get(2).y
        );

    }
}
