package lectures._09;

import java.util.ArrayList;

public class Forelesning09
{
    public static void main(String[] args) {
        System.out.println("Forelesning 09:");

        ArrayList<String> topics = new ArrayList<>();


        //# Hva skal vi igjennom i dag?
        topics.add("interface");
        topics.add("iterator");
        topics.add("meta");


        for (String topic : topics) {
            System.out.printf(" - %s%n".formatted(topic));
        }
    }
}
