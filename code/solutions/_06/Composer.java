package solutions._06;

// Oppgave #2
public class Composer
{
    //# Fields
    private String name;
    private int birthYear;

    //# Constructor
    public Composer(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    //# Getter-methods
    public String getName() {
        return this.name;
    }

    public int getBirthYear() {
        return this.birthYear;
    }
}

