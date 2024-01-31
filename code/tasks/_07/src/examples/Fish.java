package tasks._07.src.examples;


public class Fish
{
    private String name;

    public Fish(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }

    public static void main(String[] args) {
        Fish tuna1 = new Fish("Tunatius I");
        Fish tuna2 = new Fish("Tunatius II");

        System.out.println("The name of the first fish is: " + tuna1.getName());
        System.out.println("The name of the second fish is: " + tuna2.getName());
    }
}