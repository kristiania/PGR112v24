package lectures._19;

import java.util.HashMap;
import java.util.Map;

public class Forelesning19
{
    public static void main(String[] args) {
        HashMap<String, String[]> topics = new HashMap<>();

        topics.put("Starter med", new String[] {
                "Database abstraksjon",
        });

        topics.put("Fram til pausen", new String[] {
                "Lage en Database-klasse",
                "Bruk av flere konstruktører",
        });

        topics.put("Pause", new String[] {
                "15-minutter",
        });

        topics.put("Etter pausen", new String[] {
                "Spørsmål",
                "Hente ut flere rader fra databasen",
                "Legge til data (rad) i databasen",
        });

        topics.put("Før vi avslutter",  new String[] {
                "Nøkkelordet `var`",
        });


        System.out.println("Forelesning 19:");

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
