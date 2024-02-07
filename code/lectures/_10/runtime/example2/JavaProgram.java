package lectures._10.runtime.example2;

import java.util.ArrayList;

public class JavaProgram
{
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(cat);
        animals.add(dog);

        for (Animal animal : animals) {
            animal.makeSound();

            if (animal instanceof Cat) {
                ((Cat) animal).scratch();
            }
            else if (animal instanceof Dog) {
                ((Dog) animal).bark();
            }
        }
    }
}
