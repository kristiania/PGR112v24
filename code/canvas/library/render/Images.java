package canvas.library.render;

import canvas.library.math.geometry.Anchor;
import canvas.library.math.geometry.Point;

import java.awt.image.BufferedImage;


public interface Images
{
    //# Image
    void drawImage(int x, int y, String filePath, Anchor anchor);

    default void drawImage(int x, int y, String filePath) {
        this.drawImage(x, y, filePath, Anchor.TOP_LEFT);
    }

    default void drawImage(Point position, String filePath, Anchor anchor) {
        this.drawImage(position.x, position.y, filePath, anchor);
    }

    default void drawImage(Point position, String filePath) {
        this.drawImage(position.x, position.y, filePath, Anchor.TOP_LEFT);
    }


    //# Image Part
    void drawImagePart(int x, int y, int w, int h, BufferedImage image, Anchor anchor);

    default void drawImagePart(int x, int y, int w, int h, BufferedImage image) {
        this.drawImagePart(x, y, w, h, image, Anchor.TOP_LEFT);
    }


    //# Image Relative
    void drawImage(float x, float y, String filePath, Anchor anchor);

    default void drawImage(float x, float y, String filePath) {
        this.drawImage(x, y, filePath, Anchor.TOP_LEFT);
    }
}
