package examples.oop.interfaces.example1;

public class Owl implements Animal, Bird
{
    @Override
    public void makeSound() {
        System.out.println("Hoo-hoo-hooooo");
    }
}
