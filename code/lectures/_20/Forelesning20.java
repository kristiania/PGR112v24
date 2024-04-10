package lectures._20;

import java.util.HashMap;
import java.util.Map;

public class Forelesning20
{
    public static void main(String[] args) {
        Map<String, String[]> topics = new HashMap<>();

        topics.put("Starter med", new String[] {
                "Tilkoblingen til en database generelt",
                "PreparedStatement",
        });

        topics.put("Fram til pausen", new String[] {
                "Koder et enkelt system for å ta i bruk PreparedStatement",
                "Går inn på forskjellen mellom PreparedStatement og Statement",
                "Går inn på når vi bruker PreparedStatement",
        });

        topics.put("Pause", new String[] {
                "15-minutter",
        });

        topics.put("Etter pausen", new String[] {
                "Spørsmål",
                "Fortsetter på systemet vi begynte på før pausen",
        });

        topics.put("Før vi avslutter",  new String[] {
                "Hva vi skal gjøre neste uke",
        });


        System.out.println("Forelesning 20:");

        for (String key : new String[] {
                "Starter med",
                "Fram til pausen",
                "Pause",
                "Etter pausen",
                "Før vi avslutter"
        }) {
            System.out.println(STR." - \{key}:");

            for (String value : topics.get(key)) {
                System.out.println(STR."   - \{value}");
            }

            System.out.println();
        }
    }
}
