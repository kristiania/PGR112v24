package projects.game.text_adventure.src;

import java.sql.SQLOutput;

public class House extends Entity implements Interactive
{
    //# Fields
    private final int code;


    //# Constructors
    public House(Game game, int x, int y) {
        super(game, x, y, 'H');

        this.code = game.generateCode();

        game.registerCommand("enter house", this);
        game.getMap().placeEntity(this);
    }


    //# Getter-methods
    int getCode() {
        return this.code;
    }


    //# Methods
    @Override
    public void use(String command) {
        if (command.equals("enter house")) {
            if (this.getGame().isPlayerAdjacentTo(this)) {
                System.out.println();
                System.out.print("Code to open the door: ");

                try {
                    String code = Game.input.nextLine();

                    if (Integer.parseInt(code) == this.getCode()) {
                        System.out.println();
                        System.out.println("You managed to enter the house!");

                        System.exit(0);
                    }
                } catch (NumberFormatException _) {}

                System.out.println();
                System.out.println("Wrong code!");
                System.out.println();

                System.out.println("(Press enter key to continue)");

                Game.input.nextLine();

                this.getGame().setCurrentArt(this.getGame().getMap());
            }
        }
    }

    @Override
    public void draw() {
        System.out.println("    ) )        /\\");
        System.out.println("   =====      /  \\");
        System.out.println("  _|___|_____/ __ \\____________");
        System.out.println(" |::::::::::/ |  | \\:::::::::::|");
        System.out.println(" |:::::::::/  ====  \\::::::::::|");
        System.out.println(" |::::::::/__________\\:::::::::|");
        System.out.println(" |_________|  ____  |__________|");
        System.out.println("  | ______ | / || \\ | _______ |");
        System.out.println("  ||  |   || ====== ||   |   ||");
        System.out.println("  ||--+---|| |    | ||---+---||");
        System.out.println("  ||__|___||+|o   | ||___|___||");
        System.out.println("  |========| |____| |=========|");
        System.out.println(" (^^-^^^^^-|________|-^^^--^^^)");
        System.out.println(" (,, , ,, ,/________\\,,,, ,, ,)");
        System.out.println("','',,,,' /__________\\,,,',',;;");
    }
}
