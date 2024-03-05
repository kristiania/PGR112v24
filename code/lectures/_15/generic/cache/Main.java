package lectures._15.generic.cache;

import examples.data.Person;

public class Main
{
    public static void main(String[] args) {
        Cache<Person> cache = new Cache<>();

        Person defaultPerson = new Person(123);

        Person value = cache.get("Marcus", defaultPerson);
    }
}
