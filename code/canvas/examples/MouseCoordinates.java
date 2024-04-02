package canvas.examples;

import canvas.API;
import canvas.Launcher;
import canvas.Plugin;
import canvas.library.math.geometry.Point;
import canvas.library.resource.Color;

public class MouseCoordinates extends Plugin
{
    public static void main(String[] args) {
        Launcher.createWindow(640, 480, new MouseCoordinates());
    }

    private final Color textColor = new Color(255, 0, 0);
    private Point position;

    public void setup(API.Setup window) {
        this.position = window.getCenterPoint();
    }

    public void draw(API window) {
        //window.color(this.textColor);
        window.drawTextCentered(this.position, STR."Mouse[x\{window.getMouseX()}y\{window.getMouseY()}]");
    }
}
