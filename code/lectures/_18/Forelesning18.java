package lectures._18;

import java.util.ArrayList;
import java.util.List;

public class Forelesning18
{
    public static void main(String[] args) {
        List<String> topics = new ArrayList<>();

        topics.add("Database-miljø og driver");
        topics.add("Tilkobling til databasen via kode");
        topics.add("Kjøre enkle spørringer");
        topics.add("Hva de neste ukene innebærer");

        System.out.println("Forelesning 18:");

        for (String topic : topics) {
            System.out.print(" - ");
            System.out.println(topic);
        }
    }
}
