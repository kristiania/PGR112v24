package canvas.library.resource;

import java.awt.color.ColorSpace;
import java.io.Serial;

public class Color extends java.awt.Color
{
    @Serial
    private static final long serialVersionUID = 118526816881161077L;

    //# Constructors
    public Color(int r, int g, int b) {
        super(r, g, b);
    }

    public Color(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Color(int rgb) {
        super(rgb);
    }

    public Color(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Color(float r, float g, float b) {
        super(r, g, b);
    }

    public Color(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public Color(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }


    //# Static
    static public Color valueOf(java.awt.Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    static public Color valueOf(String name) {
        String colorName = name.toUpperCase().replaceAll(" ", "_");

        try {
            java.awt.Color color = (java.awt.Color) java.awt.Color.class.getDeclaredField(colorName).get(null);

            return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
