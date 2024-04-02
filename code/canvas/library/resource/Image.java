package canvas.library.resource;

import java.awt.image.BufferedImage;


public class Image
{
    //# Fields
    private String filePath;
    private BufferedImage buffer;


    //# Constructors
    public Image(String filePath, BufferedImage buffer) {
        this.filePath = filePath;
        this.buffer = buffer;
    }


    //# Getter-methods
    public String getFilePath() {
        return this.filePath;
    }

    public BufferedImage getBuffer() {
        return this.buffer;
    }

    public int getWidth() {
        return this.getBuffer().getWidth();
    }

    public int getHeight() {
        return this.getBuffer().getWidth();
    }

    public int getRGB(int x, int y) {
        return this.getBuffer().getRGB(x, y);
    }

    // TODO: memoize
    public int[][] getColors() {
        int[][] output = new int[this.getWidth()][this.getHeight()];

        for (int x = 0; x < this.getWidth(); x ++) {
            for (int y = 0; y < this.getHeight(); y ++) {
                output[x][y] = this.getBuffer().getRGB(x, y);
            }
        }

        return output;
    }


    //# Setter-methods
    public void setBuffer(BufferedImage object) {
        this.buffer = object;
    }
}
