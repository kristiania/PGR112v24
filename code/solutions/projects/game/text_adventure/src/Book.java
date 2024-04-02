package solutions.projects.game.text_adventure.src;

public class Book extends Entity implements Art, Interactive
{
    private final House house;
    private boolean open;

    public Book(Game game, int x, int y, House house) {
        super(game, x, y, 'B');

        this.house = house;
        this.open = false;

        game.registerCommand("open book", this);
        game.getMap().placeEntity(this);
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
            System.out.println(STR."  \\\\\\:;:\{this.getCode()};:;\\:;:;:;:;:;\\");
            System.out.println("   \\\\\\:;:;:;:;:;\\:;::;:;:;:\\");
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

    @Override
    public void use(String command) {
        if (command.equals("open book")) {
            if (this.getGame().isPlayerAdjacentTo(this)) {
                this.open();
            }
        }
    }
}
