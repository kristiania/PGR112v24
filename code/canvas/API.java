package canvas;

import canvas.library.helper.*;
import canvas.library.math.geometry.*;
import canvas.library.render.*;
import canvas.library.resource.*;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.function.Consumer;


public class API implements
        Rectangles,
        Squares,
        Circles,
        Triangles,
        Lines,
        Text,
        Images
{
    //# Cache
    static private final Cache<Font> cacheFont = new Cache<>();
    static private final Cache<BufferedImage> cacheImages = new Cache<>();
    static private final Cache<BasicStroke> cacheStrokes = new Cache<>();

    static {
        cacheFont.set("default", new Font(
                "Consolas",
                Font.PLAIN,
                24
        ));

        cacheStrokes.set("1", new BasicStroke(1));
    }


    //# Defaults
    static private final Font defaultFont = API.cacheFont.get("default");
    static private final Color defaultFillColor = Color.valueOf("GRAY");
    static private final Color defaultColor = Color.valueOf("BLACK");
    static private final Color defaultStrokeColor = Color.valueOf("BLACK");
    static private final int defaultStrokeThickness = 1;
    static private final Color defaultBackgroundColor = Color.valueOf("WHITE");


    //# Fields
    private Window window;
    private Graphics2D graphics;
    /** Interpolation between frames */
    private double delta;


    //# Constructors
    public API(final Window window) {
        this.window = window;
    }


    //# Getter-methods
    private Window getWindow() {
        return this.window;
    }

    public double getDelta() {
        return this.delta;
    }

    public int getWidth() {
        return this.window.getWidth();
    }

    public int getHeight() {
        return this.window.getHeight();
    }

    public Point getCursor() {
        return this.window.getCursor();
    }

    public int getMouseX() {
        return this.window.getCursor().x;
    }

    public int getMouseY() {
        return this.window.getCursor().y;
    }

    public int getHalfWidth() {
        return (int)(this.getWidth()/2.0f);
    }

    public int getHalfHeight() {
        return (int)(this.getHeight()/2.0f);
    }

    public Point getCenterPoint() {
        return new Point(this.getHalfWidth(), this.getHalfHeight());
    }

    public Point getRandomPoint() {
        return new Point(
                (int)(Math.random()*(this.getWidth() + 1)),
                (int)(Math.random()*(this.getHeight() + 1))
        );
    }


    //# Setter-methods
    void setGraphics(Graphics2D object) {
        this.graphics = object;
    }

    void setDelta(double value) {
        this.delta = value;
    }


    //# Draw API
    private Color currentColor = API.defaultColor;
    private Color currentFillColor = API.defaultFillColor;
    private Color currentStrokeColor = API.defaultStrokeColor;
    private int currentStrokeThickness = API.defaultStrokeThickness;
    private Color currentBackgroundColor = API.defaultBackgroundColor;
    private Font currentFont = API.defaultFont;

    private boolean flagFill = false;
    private boolean flagStroke = false;


    Color getColor() {
        return this.currentColor;
    }

    Color getBackgroundColor() {
        return this.currentBackgroundColor;
    }

    Color getFillColor() {
        return this.currentFillColor;
    }

    Color getStrokeColor() {
        return this.currentStrokeColor;
    }

    int getLineThickness() {
        return this.currentStrokeThickness;
    }

    Font getFont() {
        return this.currentFont;
    }

    private BasicStroke getStroke(int thickness) {
        String stroke = String.valueOf(thickness);

        if (!API.cacheStrokes.exists(stroke)) {
            API.cacheStrokes.set(stroke, new BasicStroke(thickness));
        }

        return API.cacheStrokes.get(String.valueOf(thickness));
    }

    public void color(Color object) {
        this.currentColor = object;
    }

    public void background(Color object) {
        this.currentBackgroundColor = object;
    }

    public void fill() {
        this.flagFill = true;
    }

    public void fill(Color color) {
        this.currentFillColor = color;
        this.fill();
    }

    public void lineThickness(int thickness) {
        this.currentStrokeThickness = thickness;
        this.graphics.setStroke(this.getStroke(thickness));
    }

    public void outline() {
        this.flagStroke = true;
    }

    public void outline(int thickness) {
        this.lineThickness(thickness);
        this.outline();
    }

    public void outline(int thickness, Color color) {
        this.currentStrokeColor = color;
        this.outline(thickness);
    }

    public void noFill() {
        this.flagFill = false;
    }

    public void noOutline() {
        this.flagStroke = false;
    }

    void useColor(Graphics2D graphics, Consumer<Graphics2D> function) {
        java.awt.Color currentColor = graphics.getColor();
        function.accept(graphics);
        graphics.setColor(currentColor);
    }

    void useFont(Graphics2D graphics, Consumer<Graphics2D> function) {
        Font currentFont = graphics.getFont();
        function.accept(graphics);
        graphics.setFont(currentFont);
    }


    //## Shapes
    //### Rectangle
    public void drawRectangle(int x, int y, int width, int height, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        this.useColor(this.graphics, (graphics) -> {
            graphics.setColor(this.getColor());

            if (this.flagFill) {
                graphics.fillRect(
                        (int)(x - (width*transform[0])),
                        (int)(y - (height*transform[1])),
                        width,
                        height
                );

                if (this.flagStroke) {
                    graphics.setColor(this.getStrokeColor());

                    graphics.drawRect(
                            (int)(x - (width*transform[0])),
                            (int)(y - (height*transform[1])),
                            width,
                            height
                    );
                }
            }
            else {
                graphics.drawRect(
                        (int)(x - (width*transform[0])),
                        (int)(y - (height*transform[1])),
                        width,
                        height
                );
            }
        });
    }


    //### Square
    public void drawSquare(int x, int y, int size, Anchor anchor) {
        this.drawRectangle(x, y, size, size, anchor);
    }


    //### Circle
    public void drawCircle(int x, int y, int radius, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        this.useColor(this.graphics, (graphics) -> {
            graphics.setColor(this.getColor());

            if (this.flagFill) {
                graphics.setColor(this.getFillColor());

                graphics.fillOval(
                        (int)(x - ((radius*2)*transform[0])),
                        (int)(y - ((radius*2)*transform[1])),
                        radius * 2,
                        radius * 2
                );

                if (this.flagStroke) {
                    graphics.setColor(this.getStrokeColor());

                    graphics.drawOval(
                            (int)(x - ((radius*2)*transform[0])),
                            (int)(y - ((radius*2)*transform[1])),
                            radius * 2,
                            radius * 2
                    );
                }
            }
            else {
                graphics.drawOval(
                        (int)(x - ((radius*2)*transform[0])),
                        (int)(y - ((radius*2)*transform[1])),
                        radius * 2,
                        radius * 2
                );
            }
        });
    }


    //### Triangle
    private final int[][] bufferTriangle = new int[2][4];

    public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.useColor(this.graphics, (graphics) -> {
            this.bufferTriangle[0][0] = x1;
            this.bufferTriangle[0][1] = x2;
            this.bufferTriangle[0][2] = x3;
            this.bufferTriangle[0][3] = x1;
            this.bufferTriangle[1][0] = y1;
            this.bufferTriangle[1][1] = y2;
            this.bufferTriangle[1][2] = y3;
            this.bufferTriangle[1][3] = y1;

            graphics.setColor(this.getColor());

            if (this.flagFill) {
                graphics.setColor(this.getFillColor());

                this.graphics.drawPolygon(
                        this.bufferTriangle[0],
                        this.bufferTriangle[1],
                        4
                );

                if (this.flagStroke) {
                    graphics.setColor(this.getStrokeColor());

                    this.graphics.drawPolyline(
                            this.bufferTriangle[0],
                            this.bufferTriangle[1],
                            4
                    );
                }
            } else {
                this.graphics.drawPolyline(
                        this.bufferTriangle[0],
                        this.bufferTriangle[1],
                        4
                );
            }
        });
    }


    //### Line
    public void drawLine(int x1, int y1, int x2, int y2) {
        this.graphics.drawLine(x1, y1, x2, y2);
    }


    //## Text
    public void drawText(int x, int y, String text, Font font, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        this.useFont(this.graphics, (graphics) -> {
            this.graphics.setFont(font);

            FontMetrics metrics = this.graphics.getFontMetrics();

            // TODO: handle anchor y transform
            this.graphics.drawString(
                    text,
                    x - (int)(metrics.stringWidth(text)*transform[0]),
                    y + (metrics.getAscent() - metrics.getDescent())
            );
        });
    }

    public void drawText(int x, int y, String text) {
        this.drawText(x, y, text, this.getFont(), Anchor.TOP_LEFT);
    }

    public void drawText(int x, int y, String text, Anchor anchor) {
        this.drawText(x, y, text, this.getFont(), anchor);
    }

    public void drawTextCentered(int x, int y, String text) {
        this.drawText(x, y, text, this.getFont(), Anchor.CENTER);
    }

    //## Images
    BufferedImage getImage(String fileName) {
        if (!API.cacheImages.exists(fileName)) {
            try {
                API.cacheImages.set(fileName, ImageIO.read(new File(fileName)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return API.cacheImages.get(fileName);
    }

    public void drawImage(int x, int y, String fileName, Anchor anchor) {
        this.drawImage(x, y, this.getImage(fileName), anchor);
    }

    public void drawImage(int x, int y, BufferedImage image, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        this.graphics.drawImage(
                image,
                x - (int)(image.getWidth()*transform[0]),
                y - (int)(image.getHeight()*transform[1]),
                null
        );
    }

    //### Image Part
    public void drawImagePart(Point point, int w, int h, String filePath, Anchor anchor) {
        this.drawImagePart(point.x, point.y, w, h, this.getImage(filePath), anchor);
    }

    public void drawImagePart(Point point, Rectangle part, String filePath, Anchor anchor) {
        this.drawImagePart(point.x, point.y, part.width, part.height, this.getImage(filePath), anchor);
    }

    public void drawImagePart(int x, int y, int w, int h, String filePath, Anchor anchor) {
        this.drawImagePart(x, y, w, h, this.getImage(filePath), anchor);
    }

    public void drawImagePart(int x, int y, int w, int h, BufferedImage image, Anchor anchor) {
        float[] scale = Anchor.transform(anchor);

        int offsetX = (int)(w  * scale[0]);
        int offsetY = (int)(h * scale[1]);

        this.graphics.drawImage(
                image,
                x - offsetX,
                y - offsetY,
                x - offsetX + w,
                y - offsetY + h,

                x,
                y,
                x + w,
                y + h,

                null
        );
    }


    //### Image Relative
    public void drawImage(float x, float y, String filePath, Anchor anchor) {
        this.drawImage(
                (int)(this.getWidth()*x),
                (int)(this.getHeight()*y),
                filePath,
                anchor
        );
    }

    public void drawImage(float x, float y, String filePath) {
        this.drawImage(x, y, filePath, Anchor.TOP_LEFT);
    }


    //# API.Setup
    public static class Setup
    {
        //# Fields
        private final API innerface;


        //# Constructors
        Setup(API innerface) {
            this.innerface = innerface;
        }


        //# Methods
        public Point getCenterPoint() {
            return this.innerface.getCenterPoint();
        }

        public int getWidth() {
            return this.innerface.getWidth();
        }

        public int getHeight() {
            return this.innerface.getHeight();
        }

        public int getHalfWidth() {
            return (int)(this.getWidth()/2.0);
        }

        public int getHalfHeight() {
            return (int)(this.getHeight()/2.0);
        }

        public void onMouseClick(Rectangle area, Consumer<Point> function) {
            this.innerface.getWindow().getCurrentScene().onMouseClick(area, function);
        }

        public void onMousePress(Consumer<Point> function) {
            this.innerface.getWindow().getCurrentScene().onMousePress(function);
        }

        public void onMouseRelease(Consumer<Point> function) {
            this.innerface.getWindow().getCurrentScene().onMouseRelease(function);
        }

        public void setBackgroundColor(Color color) {
            this.innerface.background(color);
        }
    }


    public static class Update
    {
        //# Fields
        private final API innerface;


        //# Constructors
        Update(API innerface) {
            this.innerface = innerface;
        }


        //# Methods
        public Point getCenterPoint() {
            return this.innerface.getCenterPoint();
        }

        public int getWidth() {
            return this.innerface.getWidth();
        }

        public int getHeight() {
            return this.innerface.getHeight();
        }

        public int getHalfWidth() {
            return (int)(this.getWidth()/2.0);
        }

        public int getHalfHeight() {
            return (int)(this.getHeight()/2.0);
        }
    }
}
