package solutions.projects.game.text_adventure.src;


public class Map implements Art
{
    private int width;
    private int height;
    private Entity[][] data;

    Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new Entity[width][height];

        for (int x = 0; x < width; x ++) {
            for (int y = 0; y < height; y ++) {
                this.data[x][y] = null;
            }
        }
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    private Entity[][] getData() {
        return this.data;
    }

    Entity getEntity(int x, int y) {
        return this.getData()[x][y];
    }


    //# Methods
    void placeEntity(Entity entity) {
        this.data[entity.getX()][entity.getY()] = entity;
    }


    void clearEntity(int x, int y) {
        this.data[x][y] = null;
    }

    @Override
    public void draw() {
        System.out.print("   ___");
        System.out.print("_".repeat(this.width));
        System.out.println("_");

        System.out.print(" / \\  ");
        System.out.print(" ".repeat(this.width));
        System.out.println(" \\.");

        String[] prefix = {
                "|   | ",
                " \\_ | ",
                "    | "
        };

        for (int y = 0; y < this.getHeight(); y ++) {
            System.out.print(prefix[Math.min(y, 2)]);

            for (int x = 0; x < this.getWidth(); x ++) {
                Entity entity = this.getEntity(x, y);

                if (entity == null) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(entity.getSymbol());
                }
            }

            System.out.println(" |.");
        }

        System.out.print("    |   ");
        System.out.print("_".repeat(this.getWidth() - 2));
        System.out.println("_|___");

        System.out.print("    |  /");
        System.out.print(" ".repeat(this.getWidth() - 2));
        System.out.println("    /.");

        System.out.print("    \\_/_");
        System.out.print("_".repeat(this.getWidth() - 2));
        System.out.println("___/.");
    }
}
