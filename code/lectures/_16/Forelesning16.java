package lectures._16;

import java.util.ArrayList;

public class Forelesning16
{
    public static void main(String[] args) {
        ArrayList<String> topics = new ArrayList<>();

        topics.add("Repetisjon og spørsmål");               // Spørsmål fra salen og Zoom-chat
        topics.add("Kodetid");                              // Kortstokk
        topics.add("Forberedelser for å jobbe visuelt");    // Sjekk ut processing.org!

        System.out.println("Forelesning 16");

        for (String topic : topics) {
            System.out.print(" - ");
            System.out.println(topic);
        }
    }
}
