package lectures._16.sandbox.casting;

public abstract class Entity {
    int health = 100;
    int damage = 10;

    void damage(Entity entity) {
        entity.health -= this.damage;
    }
}
