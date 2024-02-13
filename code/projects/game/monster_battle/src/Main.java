package projects.game.monster_battle.src;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        Player player = new Player(100, 8, 16);

        ArrayList<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster(20, 2, 5));
        monsters.add(new Monster(35, 4, 9));
        monsters.add(new Boss(64, 7, 15));

        Game game = new Game(player, monsters);

        game.start();
    }
}
