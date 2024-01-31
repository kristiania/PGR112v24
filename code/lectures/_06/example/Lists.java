package lectures._06.example;

import java.util.HashMap;

public class Lists
{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Marcus", 30);

        System.out.println(map.get("Marcus"));
    }
}
