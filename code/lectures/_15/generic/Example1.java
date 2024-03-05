package lectures._15.generic;

import java.util.ArrayList;
import java.util.HashMap;

public class Example1
{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        String[] lines = {
            "Linje 1",
            "Linje 2",
        };

        list.add("String");

        HashMap<Integer, String> map = new HashMap<>();

        map.put(123, "Text");
    }
}
