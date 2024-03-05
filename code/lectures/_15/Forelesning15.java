package lectures._15;

import java.util.ArrayList;

public class Forelesning15
{
    /** Kjører klassen som starten av et program */
    public static void main(String[] args) {
        ArrayList<String> topics = new ArrayList<>();

        topics.add("Generiske typer");
        topics.add("Javadoc");
        topics.add("Testing");

        // After the brake we removed testing and postponed it
        topics.remove(2);

        // And instead worked with a practical example
        topics.add("Practical code example - Plots from The Sims");


        System.out.println("Forelesning 15:");

        for (String topic : topics) {
            System.out.print(" - ");
            System.out.println(topic);
        }
    }
}
