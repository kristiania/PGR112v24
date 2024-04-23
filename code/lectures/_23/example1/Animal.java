package lectures._23.example1;

public class Animal
{
    private String name;
    private Animal.Type type;

    public Animal(String name, Animal.Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public Animal.Type getType() {
        return this.type;
    }


    enum Type {
        Sheep,
        Cow,
        Horse,
        Pig,
    }
}
