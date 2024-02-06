package examples.java.iterator.example2;

public class JavaProgram
{
    public static void main(String[] args) {
        Event event = new Event("Kodeklubb");

        Person A = new Person("Alpha", "One");
        Person B = new Person("Bravo", "Two");
        Person C = new Person("Charlie", "Three");

        event.registerPerson(A);
        event.registerPerson(B);
        event.registerPerson(C);

        System.out.println("---");
        System.out.println("Names 1:");

        for (String fullName : event.getFullNamesFromRegistration()) {
            System.out.printf(" - %s%n".formatted(fullName));
        }

        System.out.println("---");
        System.out.println("Names 2:");

        for (String fullName : event.getRegistration()) {
            System.out.printf(" - %s%n".formatted(fullName));
        }
    }
}
