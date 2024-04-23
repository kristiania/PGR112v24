package lectures._23.example1;

import java.util.ArrayList;

public class Farm
{
    private ArrayList<Animal> animals;

    public static void main(String[] args) {
        var farm = new Farm();

        farm.animals.add(new Pet("Ullklump", Animal.Type.Sheep, new Person()));
    }


    public boolean hasAnyAnimalWithLegs() {
        for (var animal : animals) {
            if (animal.hasLegs()) {
                return true;
            }
        }

        return false;
    }
}
