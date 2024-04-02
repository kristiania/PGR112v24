package canvas;

import canvas.library.math.geometry.Point;
import canvas.library.math.geometry.Rectangle;
import canvas.library.resource.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * Window that draws state once
 */
public class Window
{
    //# Static-fields
    static private Color defaultBackgroundColor = Color.valueOf("LIGHT_GRAY");

    //# Fields
    private API outerface = null;
    private Window.Frame frame = null;

    private HashMap<String, Window.Scene> scenes = new HashMap<>();
    private Window.Scene currentScene = null;

    private BlockingQueue<BufferStrategy> buffer = new ArrayBlockingQueue<>(1);

    private boolean initialized = false;

    private int width;
    private int height;
    private final Point cursor = new Point();


    //# Constructor
    private Window(final int width, final int height, Plugin... plugins) {
        this(
                width,
                height,
                new ArrayList<>(List.of(plugins))
        );
    }

    private Window(
            final int width,
            final int height,
            List<Plugin> plugins
    ) {
        this.outerface = new API(this);
        this.width = width;
        this.height = height;

        try {
            Scene scene = this.new Scene(width, height);
            scene.addPlugins(plugins);

            SwingUtilities.invokeAndWait(() -> {
                Window.Display display = this.new Display(this.buffer, width, height);
                Window.Frame frame = this.createFrame(width, height, display, scene);

                frame.createBufferStrategy(2);

                try {
                    this.buffer.put(frame.getBufferStrategy());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                display.setTarget(frame.getContentPane());

                this.frame = frame;
                this.initialized = true;
                this.currentScene = scene;
                this.scenes.put("main", scene);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private Window.Frame createFrame(int width, int height, Window.Display display, Window.Scene scene) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException _) {
        }

        Window.Frame frame = Window.this.new Frame(display);

        frame.setTitle("Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setIgnoreRepaint(true);

        if (frame.getContentPane() instanceof JComponent) {
            ((JComponent) frame.getContentPane()).setOpaque(false);
        }
        else {
            frame.getContentPane().setBackground(new Color(0, 0, 0, 0));
        }

        frame.add(scene, BorderLayout.CENTER);

        frame.pack();

        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }


    //# Getter-methods
    private API getAPI() {
        return this.outerface;
    }

    Scene getCurrentScene() {
        return this.currentScene;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }


    //# Methods
    void activate() {
        new Thread(() -> this.frame.display.process()).start();
    }

    synchronized void draw(Graphics2D context, int width, int height) {
        context.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        context.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // clear window
        this.getAPI().useColor(context, (graphics) -> {
            graphics.setColor(this.getAPI().getBackgroundColor());
            graphics.fillRect(0, 0, width, height);
        });

        // render current scene
        Graphics2D graphics = (Graphics2D) context.create();

        this.currentScene.draw(graphics);

        graphics.dispose();
    }

    synchronized void setColorAndDraw(Color color, Graphics2D graphics, Consumer<Graphics2D> function) {
        java.awt.Color lastColor = graphics.getColor();

        graphics.setColor(color);

        function.accept(graphics);

        graphics.setColor(lastColor);
    }

    Point getCursor() {
        return this.cursor;
    }


    //# Window.Display
    private class Display implements ResizeListener
    {
        private final BlockingQueue<BufferStrategy> buffer;
        private Container target = null;
        private final Rectangle bounds;
        private BufferedImage graphics;

        /** Desired updates per second */
        private double targetUPS = 10;
        /** Desired frames per second */
        private double targetFPS = 20;
        /** Time between updates */
        private double TBU = 1_000_000_000/this.targetUPS;
        /** Time between frames */
        private double TBF = 1_000_000_000/this.targetFPS;
        /** Maximum updates before render */
        private int MUBR = 5;
        /** Actual frames per second */
        private int FPS = 0;
        /** Actual updates per second */
        private int UPS = 0;
        /** Current frame count per second */
        private int frames = 0;
        /** Current update count per second */
        private int updates = 0;

        private boolean active = true;
        private boolean paused = false;

        public int getFPS() {
            return this.FPS;
        }

        public int getUPS() {
            return this.UPS;
        }

        private boolean isRunning() {
            return this.active;
        }

        public boolean isPaused() {
            return this.paused;
        }

        private Display(BlockingQueue<BufferStrategy> buffer, int width, int height) {
            this.buffer = buffer;

            this.bounds = new Rectangle(0, 0, width, height);

            this.graphics = GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration()
                    .createCompatibleImage(width, height);
        }

        private synchronized void setTarget(Container object) {
            this.target = object;
        }

        @Override
        public void resize(int x, int y, int width, int height) {
            synchronized (this.bounds) {
                this.bounds.setBounds(x, y, width, height);
            }
        }

        protected void process() {
            double lastUpdate = System.nanoTime();
            double lastRender = System.nanoTime();

            int previousSecond = (int) (lastUpdate/1_000_000_000);

            BufferStrategy strategy = null;

            try {
                strategy = this.buffer.poll(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.setup();

            while (this.isRunning()) {
                double now = System.nanoTime();
                int updates = 0;

                if (!this.isPaused()) {
                    while ((now - lastUpdate) > this.TBU && updates < this.MUBR) {
                        this.update();
                        updates ++;
                        lastUpdate += this.TBU;
                        this.updates++;
                    }

                    if ((now - lastUpdate) > this.TBU) {
                        lastUpdate = now - this.TBU;
                    }

                    if (strategy != null) {
                        double delta = Math.min(1.0d, (now - lastUpdate) / this.TBU);

                        try {
                            Graphics2D context = (Graphics2D) strategy.getDrawGraphics();

                            this.render(context, delta);
                            lastRender = now;

                            context.dispose();

                            if (!strategy.contentsLost()) {
                                strategy.show();
                            }
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        }

                        int currentSecond = (int) (lastUpdate / 1_000_000_000);

                        if (currentSecond > previousSecond) {
                            //System.out.println(STR."Current FPS: \{this.frames} -- UPS: \{this.updates}");

                            this.FPS = this.frames;
                            this.UPS = this.updates;
                            this.frames = 0;
                            this.updates = 0;

                            previousSecond = currentSecond;
                        }

                        while ((now - lastRender) < this.TBF && (now - lastUpdate) < this.TBU) {
                            Thread.yield();

                            try {
                                Thread.sleep(1);
                            } catch (Exception _) {}

                            now = System.nanoTime();
                        }
                    }
                }
            }
        }

        protected synchronized void setup() {
            API.Setup innerface = new API.Setup(Window.this.getAPI());

            for (Plugin plugin : Window.this.currentScene.plugins) {
                plugin.setup(innerface);
            }
        }

        protected synchronized void update() {
            for (Plugin plugin : Window.this.currentScene.plugins) {
                plugin.update();
            }
        }

        protected synchronized void render(Graphics2D context, double delta) {
            Graphics2D canvas = this.graphics.createGraphics();

            Window.this.getAPI().setDelta(delta);
            Window.this.draw(canvas, this.graphics.getWidth(), this.graphics.getHeight());

            canvas.dispose();

            final Graphics GUI = context.create();

            synchronized (this.bounds) {
                GUI.translate(this.bounds.x, this.bounds.y);

                Graphics viewport = context.create();

                viewport.drawImage(this.graphics, this.bounds.x, this.bounds.y, null);

                viewport.dispose();
            }

            if (this.target != null) {
                try {
                    SwingUtilities.invokeAndWait(() -> {
                        if (this.target instanceof JComponent) {
                            this.target.paintComponents(GUI);
                        }
                        else {
                            this.target.paintAll(GUI);
                        }
                    });
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            GUI.dispose();

            this.frames ++;
        }
    }


    //# Window::Frame
    private class Frame extends JFrame implements ComponentListener
    {
        //# Fields
        private final Window.Display display;


        //# Constructors
        private Frame(Window.Display display) {
            super();

            super.addComponentListener(this);
            this.display = display;
        }


        //# Methods-overrides
        @Override
        public void componentResized(ComponentEvent e) {
            Insets margin = this.getInsets();

            this.display.resize(
                    margin.left, margin.top,
                    this.getWidth() - margin.left - margin.right,
                    this.getHeight() - margin.top - margin.bottom
            );
        }

        @Override
        public void componentMoved(ComponentEvent e) {}

        @Override
        public void componentShown(ComponentEvent e) {}

        @Override
        public void componentHidden(ComponentEvent e) {}
    }


    //# Window::Scene
    public class Scene extends JPanel
    {
        //# Fields
        private Dimension size;
        private final ArrayList<Plugin> plugins = new ArrayList<>();
        private final HashMap<Rectangle, Consumer<Point>> mouseClick = new HashMap<>();
        private final ArrayList<Consumer<Point>> mousePress = new ArrayList<>();
        private final ArrayList<Consumer<Point>> mouseRelease = new ArrayList<>();


        //# Constructors
        private Scene(final int width, final int height) {
            super();

            this.setLayout(null);
            this.setOpaque(false);

            Dimension size = new Dimension(width, height);

            this.setSize(size);
            this.setPreferredSize(size);

            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point click = Point.valueOf(e.getPoint());

                    for (Rectangle area : Scene.this.mouseClick.keySet()) {
                        if (click.x >= area.x
                                && click.x <= (area.x + area.width)
                                && click.y >= area.y
                                && click.y <= (area.y + area.height)
                        ) {
                            Scene.this.mouseClick.get(area).accept(click);
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    Point click = Point.valueOf(e.getPoint());

                    for (Consumer<Point> function : Scene.this.mousePress) {
                        function.accept(click);
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Point click = Point.valueOf(e.getPoint());

                    for (Consumer<Point> function : Scene.this.mouseRelease) {
                        function.accept(click);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

            this.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Window.this.cursor.x = e.getX();
                    Window.this.cursor.y = e.getY();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    Window.this.cursor.x = e.getX();
                    Window.this.cursor.y = e.getY();
                }
            });
        }


        //# Methods
        private void addPlugins(List<Plugin> plugins) {
            this.plugins.addAll(plugins);
        }

        private void addPlugins(Plugin... plugins) {
            this.plugins.addAll(List.of(plugins));
        }

        synchronized void draw(Graphics2D graphics) {
            API methods = Window.this.getAPI();

            graphics.setColor(methods.getColor());

            methods.setGraphics(graphics);

            for (Plugin plugin : plugins) {
                plugin.draw(methods);
            }
        }

        void onMouseClick(Rectangle area, Consumer<Point> function) {
            this.mouseClick.put(area, function);
        }

        void onMousePress(Consumer<Point> function) {
            this.mousePress.add(function);
        }

        void onMouseRelease(Consumer<Point> function) {
            this.mouseRelease.add(function);
        }
    }


    interface ResizeListener {
        void resize(int x, int y, int width, int height);
    }


    //# Static
    static public void initialize(final int width, final int height, List<Plugin> plugins) {
        Window window = new Window(width, height, plugins);

        window.activate();
    }
}
