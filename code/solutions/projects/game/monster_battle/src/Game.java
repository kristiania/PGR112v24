package solutions.projects.game.monster_battle.src;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
    //# Fields
    private final ArrayList<Monster> monsters;
    private final Battle battle;


    //# Constructors
    Game(Player player, ArrayList<Monster> monsters) {
        this.monsters = monsters;
        this.battle = new Battle(player, null);
    }


    void start() {
        //# Start the game

        while (this.getMonstersLeft() > 0) {
            this.battle.setCurrentMonster(this.getMonsters().removeFirst());

            this.battle.start();

            if (!this.battle.didPlayerSurvive()) {
                System.out.println("The player did not manage to beat all the monsters!");

                return;
            }
        }

        System.out.println("The player managed to beat all the monsters!!!");
    }



    //# Getter-methods
    ArrayList<Monster> getMonsters() {
        return this.monsters;
    }

    Battle getBattle() {
        return this.battle;
    }

    Player getPlayer() {
        return this.getBattle().getPlayer();
    }

    int getMonstersLeft() {
        return this.getMonsters().size();
    }


    //# Static-methods
    static int getRandomDamage(int max) {
        return Game.getRandomDamage(0, max);
    }

    static int getRandomDamage(int min, int max) {
        Random RNG = new Random();

        return RNG.nextInt(max - min) + min;
    }
}
