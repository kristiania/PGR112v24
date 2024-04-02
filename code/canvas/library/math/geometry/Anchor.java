package canvas.library.math.geometry;

import java.util.EnumMap;


public enum Anchor
{
    CENTER
    , TOP
    , BOTTOM
    , LEFT
    , RIGHT
    , TOP_LEFT
    , TOP_RIGHT
    , BOTTOM_LEFT
    , BOTTOM_RIGHT
    ;

    private static final EnumMap<Anchor, float[]> data = new EnumMap<>(Anchor.class);

    static {
        data.put(Anchor.CENTER,         new float[] { 0.5f, 0.5f });
        data.put(Anchor.TOP,            new float[] { 0.5f, 0.0f });
        data.put(Anchor.TOP_LEFT,       new float[] { 0.0f, 0.0f });
        data.put(Anchor.TOP_RIGHT,      new float[] { 1.0f, 0.0f });
        data.put(Anchor.BOTTOM,         new float[] { 0.5f, 1.0f });
        data.put(Anchor.BOTTOM_LEFT,    new float[] { 0.0f, 1.0f });
        data.put(Anchor.BOTTOM_RIGHT,   new float[] { 1.0f, 1.0f });
        data.put(Anchor.LEFT,           new float[] { 0.0f, 0.5f });
        data.put(Anchor.RIGHT,          new float[] { 1.0f, 0.5f });
    }

    public static float[] transform(Anchor position) {
        return Anchor.data.get(position);
    }
}
