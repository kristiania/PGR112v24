package examples.java.iterator.example2;

import java.util.Iterator;

public class Event
{
    //# Fields
    private String name;
    private Registration registration;


    //# Constructors
    public Event(String name) {
        this.setName(name);
        this.setRegistration(new Registration(this));
    }


    //# Getter-methods
    public String getName() {
        return this.name;
    }

    public Registration getRegistration() {
        return this.registration;
    }

    public Iterable<String> getFullNamesFromRegistration() {
        return this.getRegistration();
    }


    //# Setter-methods
    private void setName(String value) {
        this.name = value;
    }

    private void setRegistration(Registration value) {
        this.registration = value;
    }


    //# Methods
    public void registerPerson(Person person) {
        this.registration.register(person);
    }

    public void unregisterPerson(Person person) {
        this.registration.unregister(person);
    }
}
