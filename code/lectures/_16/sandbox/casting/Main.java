package lectures._16.sandbox.casting;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {

        Monster monster1 = new Monster();
        Player player1 = new Player();

        ArrayList<Entity> entities = new ArrayList<>();

        entities.add(monster1);
        entities.add(player1);

        for (Entity entity : entities) {
            entity.health -= 25;

            if (entity instanceof Player) {
                Player player = (Player) entity;

                if (player.mana >= 25) {
                    player.health += 10;
                    player.mana -= 25;
                }
            }
        }

        monster1.damage(player1);

    }


}
