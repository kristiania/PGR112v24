package examples.java.iterator.example2;

import java.util.ArrayList;
import java.util.Iterator;

public class Registration implements Iterable<String>
{
    //# Fields
    private Event event;
    private ArrayList<Person> persons;


    //# Constructor
    public Registration(Event event) {
        this.event = event;
        this.persons = new ArrayList<>();
    }


    //# Getter-methods
    public Event getEvent() {
        return this.event;
    }

    public ArrayList<Person> getPersons() {
        return this.persons;
    }


    //# Methods
    public void register(Person person) {
        this.persons.add(person);
    }

    public void unregister(Person person) {
        this.persons.add(person);
    }

    @Override
    public Iterator<String> iterator() {
        return new ListOfFullNames(this);
    }
}

class ListOfFullNames implements Iterator<String>
{
    private Registration data;
    private int index;

    public ListOfFullNames(Registration registration) {
        this.data = registration;
    }

    private ArrayList<Person> getData() {
        return this.data.getPersons();
    }

    @Override
    public boolean hasNext() {
        return index < this.getData().size();
    }

    @Override
    public String next() {
        Person person = this.getData().get(this.index);

        this.index += 1;

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        return "%s %s".formatted(firstName, lastName);
    }
}
