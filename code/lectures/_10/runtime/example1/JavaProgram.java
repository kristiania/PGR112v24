package lectures._10.runtime.example1;

import java.util.ArrayList;

public class JavaProgram
{
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Cat());
        animals.add(new Dog());

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
