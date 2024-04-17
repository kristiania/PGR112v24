package lectures._22;

import java.util.ArrayList;


public class Forelesning22
{
    public static void main(String[] args) {
        ArrayList<String> topics = new ArrayList<>();

        topics.add("Fortsette på koden fra i går");
        topics.add("CRUD");
        topics.add("Lese fra fil og inn i database");
        topics.add("- Tips til forberedelser neste uke");

        System.out.println("Forelesning 22");

        for (String topic : topics) {
            System.out.print(" - ");
            System.out.println(topic);
        }
    }
}
