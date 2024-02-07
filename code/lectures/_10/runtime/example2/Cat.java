package lectures._10.runtime.example2;

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
