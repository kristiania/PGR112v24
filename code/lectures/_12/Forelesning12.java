package lectures._12;

import java.util.ArrayList;

public class Forelesning12 {
    public static void main(String[] args) {
        System.out.println("Velkommen til forelesning 12!");

        //# Oppretter en terning
        Die die = new Die(6);

        //# Kaster terningen en gang
        System.out.print("Å kaste terningen1 gang ga oss: ");
        System.out.println(die.roll());

        //# Kaste terninger flere ganger
        double amountOfThrows = 1_000_000;
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < amountOfThrows; i ++) {
            results.add(die.roll());
        }

        System.out.print("Antall kast gjort: ");
        System.out.println(results.size());

        int sum = 0;

        for (Integer result : results) {
            sum += result;
        }

        System.out.printf("Sum: %d%n".formatted(sum));

        System.out.print("Gjennomsnitt: ");
        System.out.printf("%f%n", sum/amountOfThrows);
    }
}
