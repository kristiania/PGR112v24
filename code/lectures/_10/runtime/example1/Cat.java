package lectures._10.runtime.example1;

public class Cat extends Animal
{
    public void scratch() {
        System.out.println("Cat scratches at something");
    }

    @Override
    public void makeSound() {
        System.out.println("Cat makes a sound");
    }
}
