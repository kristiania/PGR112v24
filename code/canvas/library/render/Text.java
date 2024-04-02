package canvas.library.render;

import canvas.library.math.geometry.Anchor;
import canvas.library.math.geometry.Point;

import java.awt.Font;


public interface Text
{
    void drawText(int x, int y, String text, Font font, Anchor anchor);

    default void drawText(Point position, String text, Font font, Anchor anchor) {
        this.drawText(position.x, position.y, text, font, anchor);
    }

    default void drawTextCentered(int x, int y, String text, Font font) {
        this.drawText(x, y, text, font, Anchor.CENTER);
    }

    default void drawTextCentered(Point position, String text, Font font) {
        this.drawText(position.x, position.y, text, font, Anchor.CENTER);
    }

    void drawTextCentered(int x, int y, String text);

    default void drawTextCentered(Point position, String text) {
        this.drawTextCentered(position.x, position.y, text);
    }
}
