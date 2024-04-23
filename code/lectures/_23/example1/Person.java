package lectures._23.example1;

public class Person
{
    private long number;
    private boolean petOwner = false;

    public long getIdentificationNumber() {
        return this.number;
    }

    public boolean hasPet() {
        return this.petOwner;
    }
}
