package examples.java.collections.map;

import java.util.HashMap;
import java.util.Map;

public class ExampleHashMap
{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("abc", 123);
        map.put("def", 456);
        map.put("ghi", 789);

        System.out.println("Key %s contains the value: %d%n".formatted(
                "abc", map.get("abc")
        ));

        System.out.println("Key %s contains the value: %d%n".formatted(
                "def", map.get("def")
        ));

        System.out.println("Key %s contains the value: %d%n".formatted(
                "ghi", map.get("ghi")
        ));

        // Vi kan loope igjennom nøklene og printe de ut:

        System.out.println("---");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // Eller printe ut verdiene:
        System.out.println("---");
        for (int value : map.values()) {
            System.out.println(value);
        }

        // Vi kan også hente ut verdier og tilsvarende nøkler
        // i en og samme sleng:
        System.out.println("---");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
