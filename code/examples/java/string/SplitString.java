package examples.java.string;

public class SplitString
{
    public static void main(String[] args) {
        String line = "Dette er en linje med flere forskjellige ord";

        String[] words = line.split(" ");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
