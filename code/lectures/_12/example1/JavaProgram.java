package lectures._12.example1;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaProgram
{
    public static void main(String[] args) {
        Person person1 = new Person(123);
        Person person2 = new Person(456);
        Person person3 = new Person(789);

        HashMap<Long, Person> personMap = new HashMap<>();
        ArrayList<Person> personList = new ArrayList<>();

        personMap.put(person1.getPersonNumber(), person1);
        personMap.put(person2.getPersonNumber(), person2);
        personMap.put(person3.getPersonNumber(), person3);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        long personNr = 123L;

        Person personOfInterest = null;

        for (Person person : personList) {
            if (person.getPersonNumber() == personNr) {
                personOfInterest = person;
                break;
            }
        }

        System.out.println(personOfInterest);
    }
}
