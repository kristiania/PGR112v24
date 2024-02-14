package lectures._12;


import java.util.Random;


//# Terning
public class Die
{
    //# Fields
    private final int sides;

    //# Constructors
    Die(int sides) {
        this.sides = sides;
    }

    //# Getter-methods
    public int getSides() {
        return this.sides;
    }

    //# Methods
    public int roll() {
        Random RNG = new Random();

        return RNG.nextInt(this.getSides()) + 1;
    }
}
