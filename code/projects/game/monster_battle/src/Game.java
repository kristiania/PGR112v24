package projects.game.monster_battle.src;

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
        this.battle = new Battle(player, monsters.getFirst());
    }


    void start() {
        //# Start the game

        // The player battles against the monsters until:
        // - all monsters have dies
        // - or the player dies
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
