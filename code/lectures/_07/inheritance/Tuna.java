package lectures._07.inheritance;


public class Tuna extends Fish
{
    //# Fields
    private String name;


    //# Constructors
    public Tuna(String name) {
        super("Tuna");

        this.setName(name);
    }


    //# Getter-methods
    public String getName() {
        return this.name;
    }


    //# Setter-methods
    private void setName(String value) {
        this.name = value;
    }


    //# Methods
    public void sayName() {
        super.makeFishSay("My name is " + this.getName() + "!");
    }
}