package lectures._17;

import java.util.ArrayList;

public class Forelesning17
{
    public static void main(String[] args) {
        ArrayList<String> topics = new ArrayList<>();

        topics.add("Repetisjon og spørsmål");               // Spørsmål fra salen og Zoom-chat
        topics.add("Forberedelser: Forelesning 18");     // Sjekk ut processing.org!

        System.out.println("Forelesning 17");

        for (String topic : topics) {
            System.out.print(" - ");
            System.out.println(topic);
        }
    }
}
