package examples.oop.abstraction.example2;


public abstract class Entity
{
    //# Fields
    protected int health = 0;
    protected int attack = 1;
    protected int defense = 1;


    //# Getter-methods
    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }
}
