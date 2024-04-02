package canvas.examples;

import canvas.API;
import canvas.Launcher;
import canvas.Plugin;

public class KristianiaLogo extends Plugin
{
    public static void main(String[] args) {
        Launcher.createWindow(640, 480, new KristianiaLogo());
    }

    public void draw(API window) {
        window.drawImageCentered(
                window.getCenterPoint(), "files/kristiania/logo.png");
    }
}
