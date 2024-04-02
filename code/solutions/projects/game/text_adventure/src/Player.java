package solutions.projects.game.text_adventure.src;

public class Player extends Entity implements Interactive
{
    public Player(Game game, int x, int y) {
        super(game, x, y, 'P');

        game.setPlayer(this);

        game.registerCommand("go up", this);
        game.registerCommand("go down", this);
        game.registerCommand("go left", this);
        game.registerCommand("go right", this);
        game.registerCommand("do nothing", this);
    }

    @Override
    public void use(String command) {
        this.getGame().setCurrentArt(this.getGame().getMap());

        switch (command) {
            case "go up" -> {
                if (this.getY() > 0) {
                    Entity entityAhead = this.getGame().getMap().getEntity(
                            this.getX(), this.getY() - 1
                    );

                    if (entityAhead == null) {
                        this.setY(this.getY() - 1);
                    }
                    else {
                        this.getGame().setCurrentArt(entityAhead);
                    }
                }
            }

            case "go down" -> {
                if (this.getY() < this.getGame().getMap().getHeight() - 1) {
                    Entity entityAhead = this.getGame().getMap().getEntity(
                            this.getX(), this.getY() + 1
                    );

                    if (entityAhead == null) {
                        this.setY(this.getY() + 1);
                    }
                    else {
                        this.getGame().setCurrentArt(entityAhead);
                    }
                }
            }

            case "go left" -> {
                if (this.getX() > 0) {
                    Entity entityAhead = this.getGame().getMap().getEntity(
                            this.getX() - 1, this.getY()
                    );

                    if (entityAhead == null) {
                        this.setX(this.getX() - 1);
                    } else {
                        this.getGame().setCurrentArt(entityAhead);
                    }
                }
            }

            case "go right" -> {
                if (this.getX() < this.getGame().getMap().getWidth() - 1) {
                    Entity entityAhead = this.getGame().getMap().getEntity(
                            this.getX() + 1, this.getY()
                    );

                    if (entityAhead == null) {
                        this.setX(this.getX() + 1);
                    }
                    else {
                        this.getGame().setCurrentArt(entityAhead);
                    }
                }
            }

            default -> System.out.println();
        }
    }

    @Override
    public void draw() {
        System.out.println("This is the player being drawn with no art!");
    }
}
