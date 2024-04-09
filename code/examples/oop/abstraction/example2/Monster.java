package examples.oop.abstraction.example2;

public class Monster extends Entity
{
    public Monster(Monster.Type type) {
        switch (type) {
            case BOSS -> {
                super.attack = 3;
                super.defense = 2;
            }

            case NORMAL -> {
                super.attack = 2;
            }

            default -> {
                super.defense = 0;
            }
        }
    }

    public enum Type {
        NORMAL,
        BOSS
    }
}
