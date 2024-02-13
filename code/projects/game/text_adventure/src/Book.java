package projects.game.text_adventure.src;

public class Book implements Art
{
    private final House house;
    private boolean open;

    public Book(House house) {
        this.house = house;
        this.open = false;
    }


    //# Getter-methods
    private House getHouse() {
        return this.house;
    }

    private int getCode() {
        return this.getHouse().getCode();
    }

    boolean isOpen() {
        return this.open;
    }

    void open() {
        this.open = true;
    }


    //# Methods
    @Override
    public void draw() {
        if (this.isOpen()) {
            System.out.println("      _.--._  _.--._");
            System.out.println(",-=.-\":;:;:;\\':;:;:;\"-._");
            System.out.println("\\\\\\:;:;:;:;:;\\:;:;:;:;:;\\");
            System.out.println(" \\\\\\:;:;:;:;:;\\:;:;:;:;:;\\");
            System.out.println("  \\\\\\:;:;:;:;:;\\:;:;:;:;:;\\");
            System.out.println("   \\\\\\:;:;:;:;:;\\:;::;:;:;:\\\n");
            System.out.println("    \\\\\\;:;::;:;:;\\:;:;:;::;:\\");
            System.out.println("     \\\\\\;;:;:_:--:\\:_:--:_;:;\\");
            System.out.println("      \\\\\\_.-\"      :      \"-._\\");
            System.out.println("       \\`_..--\"\"--.;.--\"\"--.._=>");
            System.out.println("        \"");
        }
        else {
            System.out.println("        _.-\"\\");
            System.out.println("    _.-\"     \\");
            System.out.println(" ,-\"          \\");
            System.out.println("( \\            \\");
            System.out.println(" \\ \\            \\");
            System.out.println("  \\ \\            \\");
            System.out.println("   \\ \\         _.-;");
            System.out.println("    \\ \\    _.-\"   :");
            System.out.println("     \\ \\,-\"    _.-\"");
            System.out.println("      \\(   _.-\"");
            System.out.println("       `--\"");
        }
    }
}
