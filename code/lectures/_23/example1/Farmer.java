package lectures._23.example1;

public class Farmer extends Person
{
    public void fixHooves(Animal animal) {
        if (animal.getType().equals(Animal.Type.Cow)) {
            if (animal.hasLegs()) {
                // fix hooves
            }
        }
    }
}
