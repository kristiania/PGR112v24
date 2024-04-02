package solutions.projects.game.text_adventure.src;


public class Main
{
    public static void main(String[] args) {
        Game game = new Game(6, 4);

        Player player = new Player(game, 0, 0);
        House house = new House(game, 3, 3);
        Book book = new Book(game, 2, 1, house);

        game.printMap();

        game.handleInput();
    }
}
