package canvas.library.render;

import canvas.library.math.geometry.Anchor;
import canvas.library.math.geometry.Dimension;
import canvas.library.math.geometry.Point;


public interface Squares
{
    //# Outline
    void drawSquare(int x, int y, int size, Anchor anchor);

    default void drawSquare(Point position, int size, Anchor anchor) {
        this.drawSquare(position.x, position.y, size, anchor);
    }

    default void drawSquare(int x, int y, int size) {
        this.drawSquare(x, y, size, Anchor.TOP_LEFT);
    }

    default void drawSquare(Point position, int size) {
        this.drawSquare(position.x, position.y, size, Anchor.TOP_LEFT);
    }
}
