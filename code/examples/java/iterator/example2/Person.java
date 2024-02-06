package examples.java.iterator.example2;

public class Person
{
    //# Fields
    private String firstName;
    private String lastName;


    //# Constructors
    public Person(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }


    //# Getter-methods
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    //# Setter-methods
    private void setFirstName(String value) {
        this.firstName = value;
    }

    private void setLastName(String value) {
        this.lastName = value;
    }


    //# Methods
    @Override
    public String toString() {
        return "%s[firstName=\"%s\"; lastName=\"%s\";]%n".formatted(
                this.getClass().toString(),
                this.getFirstName(),
                this.getLastName()
        );
    }
}
