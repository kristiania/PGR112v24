package projects.game.text_adventure.src;


public class Main
{
    public static void main(String[] args) {
        Game game = new Game(7, 5);

        Player player = new Player(game, 0, 0);
        House house = new House(game, 3, 3);

        game.printMap();

        game.handleInput();
    }
}
