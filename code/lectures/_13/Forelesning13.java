package lectures._13;


public class Forelesning13
{
    public static void main(String[] args) {
        System.out.println("Velkommen til forelesning 13!");

        String[] topics = {
                "Static code blocks",
                "Inner classes",
        };

        System.out.println("Oversikt:");

        for (String topic : topics) {
            System.out.print(" - ");
            System.out.println(topic);
        }
    }
}
