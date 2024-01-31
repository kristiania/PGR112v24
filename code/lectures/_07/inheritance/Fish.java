package lectures._07.inheritance;


public class Fish
{
    //# Fields
    private String type;


    //# Constructors
    public Fish(String type) {
        this.type = type;
    }


    //# Getter-methods
    public String getType() {
        return this.type;
    }


    //# Setter-methods
    private void setType(String value) {
        this.type = value;
    }


    //# Methods
    public void makeFishSay(String phrase) {
        System.out.println(this.getType() + " says: " + phrase);
        // System.out.printf("%s says: %s", this.getType(), phrase);
    }
}