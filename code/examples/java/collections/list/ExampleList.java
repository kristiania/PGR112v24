package examples.java.collections.list;

import java.util.ArrayList;
import java.util.List;

public class ExampleList
{
    public static void main(String[] args) {
        // upcasting
        final List<String> list = new ArrayList<>();

        // Legger til i listen
        list.add("Index 0");
        list.add("Hello");
        list.add("0");
        list.add("Student");

        // Fjerner noe fra listen
        list.removeFirst();         // Fjerner "Index 0"

        list.remove("Hello");    // Fjerner "Hello"

        list.remove(1);      // Fjerner "Student"
                                    // (startet som indeks 2, er nå 0 pga. vi fjernet 2 elementer)

        // Henter ut første element i listen
        System.out.println(list.getFirst());

        // Her oppretter vi en liste med tall direkte via den statiske `.of(...)`-metoden
        List<Integer> numbers = List.of(1, 2, 3);

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
