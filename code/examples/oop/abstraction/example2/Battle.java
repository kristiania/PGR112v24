package examples.oop.abstraction.example2;


public class Battle
{
    //# Fields
    private final Player player;
    private final Entity opponent;
    private boolean PvP = false;


    //# Constructors
    public Battle(Player player, Entity opponent) {
        this.player = player;
        this.opponent = opponent;

        if (opponent instanceof Player) {
            this.PvP = true;
        }
    }


    //# Getter-methods
    public Player getPlayer() {
        return this.player;
    }

    public Entity getOpponent() {
        return this.opponent;
    }

    public Player getOpponentAsPlayer() {
        if (this.isPlayerVersusPlayer()) {
            return (Player) this.getOpponent();
        }

        throw new RuntimeException("Opponent is not an instance of the Player-class!");
    }

    public boolean isPlayerVersusPlayer() {
        return this.PvP;
    }
}
