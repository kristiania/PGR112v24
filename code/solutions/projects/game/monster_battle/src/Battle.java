package solutions.projects.game.monster_battle.src;

public class Battle
{
    //# Fields
    private final Player player;
    private Monster monster;
    private boolean playerDidNotSurive = false;


    //# Constructors
    Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }


    //# Getter-methods
    Player getPlayer() {
        return this.player;
    }

    Monster getCurrentMonster() {
        return this.monster;
    }

    boolean didPlayerSurvive() {
        return !this.playerDidNotSurive;
    }


    //# Setter-methods
    void setCurrentMonster(Monster monster) {
        this.monster = monster;
    }


    //# Methods
    void start() {
        System.out.println("!!! Battle start !!!");

        while (this.getPlayer().getHealth() > 0 && this.getCurrentMonster().getHealth() > 0) {

            if (this.getCurrentMonster() instanceof Boss) {
                System.out.println("BOSS FIGHT!!!");
            }
            int damage = this.getPlayer().getDamage();

            System.out.println(STR."Player attacks monster for \{damage} damage");
            boolean monsterDied = this.getCurrentMonster().damage(damage);

            if (!monsterDied) {
                damage = this.getCurrentMonster().getDamage();

                System.out.println(STR."Monster attacks player for \{damage} damage");
                boolean playerDied = this.player.damage(damage);

                if (playerDied) {
                    this.playerDidNotSurive = true;
                }
            }
            else {
                System.out.println("Monster died!");
            }
        }

        System.out.println("!!! Battle ended !!!");
        System.out.println("---");
    }
}
