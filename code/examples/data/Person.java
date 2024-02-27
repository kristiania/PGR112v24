package examples.data;

public class Person
{
    //# Fields
    /** Person-nummer som identifiser personen */
    private final long identifier;
    /** Hele navnet til personen */
    private String name = "Ukjent";


    //# Constructor
    public Person(long number) {
        this.identifier = number;
    }


    //# Getter-methods

    /**
     * @return Number that identifies a person
     */
    public long getIdentifier() {
        return this.identifier;
    }

    /**
     * @return Full name of the person
     */
    public String getName() {
        return this.name;
    }


    //# Setter-methods

    /**
     * @param value New name of the person
     */
    public void setName(String value) {
        this.name = value;
    }
}
