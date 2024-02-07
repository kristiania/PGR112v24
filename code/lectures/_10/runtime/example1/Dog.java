package lectures._10.runtime.example1;

public class Dog extends Animal
{
    public void bark() {
        System.out.println("Dog barks at something");
    }

    @Override
    public void makeSound() {
        System.out.println("Dog makes a sound");
    }
}
