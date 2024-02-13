package projects.game.text_adventure.src;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;


public class Game implements Interactive
{
    //# Static-fields
    static final Scanner input = new Scanner(System.in);
    private static final int minSize = 3;
    private static final int maxSize = 12;


    //# Fields
    private Map map;
    private Player player = null;
    private HashMap<String, Interactive> commands;
    private Art currentArt;



    //# Constructors
    Game(int width, int height) {
        this.map = new Map(
                Math.max(Game.minSize, Math.min(Game.maxSize, width)),
                Math.max(Game.minSize, Math.min(Game.maxSize, height))
        );

        this.commands = new HashMap<>();

        this.registerCommand("help", this);
        this.registerCommand("exit", this);

        this.currentArt = this.map;
    }


    //# Getter-methods
    Map getMap() {
        return this.map;
    }

    Player getPlayer() {
        return this.player;
    }


    //# Setter-methods
    void setPlayer(Player value) {
        this.player = value;

        this.getMap().placeEntity(value);
    }

    void setCurrentArt(Art art) {
        this.currentArt = art;
    }


    //# Methods
    void printMap() {
        this.map.draw();
    }

    void registerCommand(String command, Interactive entity) {
        this.commands.put(command, entity);
    }

    void tryCommand(String command) {
        if (this.hasCommand(command)) {
            this.commands.get(command).use(command);
        }
    }

    boolean hasCommand(String command) {
        return this.commands.containsKey(command);
    }

    void handleInput() {
        System.out.println();
        System.out.print("> ");

        String input = Game.input.nextLine();

        if (this.hasCommand(input)) {
            this.tryCommand(input);

            System.out.println();
            this.currentArt.draw();
        }

        this.handleInput();
    }

    boolean isPlayerAdjacentTo(Entity entity) {
        return (
            Math.abs(entity.getX() - this.getPlayer().getX()) == 1
         || Math.abs(entity.getY() - this.getPlayer().getY()) == 1
        );
    }

    int generateCode() {
        int output = 0;
        Random RNG = new Random();

        output += (RNG.nextInt(8) + 1)*1000;
        output += (RNG.nextInt(8) + 1)*100;
        output += (RNG.nextInt(8) + 1)*10;
        output += (RNG.nextInt(8) + 1);

        return output;
    }

    @Override
    public void use(String command) {
        if (command.equals("help")) {
            System.out.println("Available commands:");

            for (String key : this.commands.keySet()) {
                System.out.printf(" - %s%n".formatted(key));
            }

            System.out.println();
            System.out.println("(Press enter key to continue)");

            Game.input.nextLine();
        }
        else if (command.equals("exit")) {
            System.exit(0);
        }
    }
}
