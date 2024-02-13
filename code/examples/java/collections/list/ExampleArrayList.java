package examples.java.collections.list;

import java.util.ArrayList;

public class ExampleArrayList {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        lines.add("Linje 1");
        lines.add("Linje 2");

        // Legge til verdier via en loop
        for (int i = 3; i <= 10; i ++) {
            lines.add("Linje %d".formatted(i));
        }

        // Fjerne en av linjene via indeks-verdi
        lines.remove(2);

        // Lese av verdiene via en loop
        for (String line : lines) {
            System.out.println(line);
        }

        // Sjekke om listen ikke er tom
        if (!lines.isEmpty()) {
            System.out.println("Listen er nå tom!");
        }

        // I stedenfor å jobbe med mange variabler som har samme datatype,
        // kan vi samle de i en liste med verdier og behandle de deretter
    }
}
