package lectures._23.example1;

public class Pet extends Animal
{
    private Person owner;

    public Pet(String name, Animal.Type type, Person owner) {
        super(name, type);

        this.owner = owner;
    }
}
