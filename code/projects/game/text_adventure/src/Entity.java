package projects.game.text_adventure.src;

public abstract class Entity implements Art
{
    protected Game game;
    private int x;
    private int y;
    private char symbol;

    Entity(Game game, int x, int y, char symbol) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    protected Game getGame() {
        return this.game;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int value) {
        this.getGame().getMap().clearEntity(this.getX(), this.getY());

        this.x = value;

        this.getGame().getMap().placeEntity(this);
    }

    void setY(int value) {
        this.getGame().getMap().clearEntity(this.getX(), this.getY());

        this.y = value;

        this.getGame().getMap().placeEntity(this);
    }

    char getSymbol() {
        return this.symbol;
    }


    //# Setter-methods
    protected void setSymbol(char value) {
        this.symbol = value;
    }
}
