package examples.java.collections.map;

import java.util.HashMap;
import java.util.Map;

public class ExampleHashMap
{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Et HashMap er en datastruktur
        // hvor vi har nøkler som linker direkte til verdier

        // det vil si at vi kan bruke nøklene for å hente
        // ut verdiene vi har lagret knyttet til nøkkelen

        map.put("abc", 123);
        map.put("def", 456);

        System.out.println("Key %s contains the value: %d%n".formatted(
                "abc", map.get("abc")
        ));

        // Vi kan loope igjennom nøklene og printe de ut:

        System.out.println("---");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // Eller print ut verdiene:
        System.out.println("---");
        for (int value : map.values()) {
            System.out.println(value);
        }

        // Men, det som er viktig å huske på her
        // dersom vi printer ut via en loop som disse to er:
        // rekkefølgen er ikke noe vi kan gjøre oss avhengig av
        // det vil si, den vil ikke liste opp nøklene eller verdiene
        // utifra rekkefølgene de ble lagt til!

        // Vi kan også hente ut verdier og tilsvarende nøkkler
        // i en og samme sleng:
        System.out.println("---");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
