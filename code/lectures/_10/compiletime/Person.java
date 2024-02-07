package lectures._10.compiletime;

public class Person
{
    public void sayWords(String word1) {
        System.out.println("Method 1");
        System.out.println(word1);
    }

    public void sayWords(String... words) {
        System.out.println("Method 2");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public void sayWords(String word1, String word2, String word3) {
        System.out.println("Method 3");
        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3);
    }


    public static void main(String[] args) {
        Person person = new Person();

        // Hvilken metode som velges
        // bestemmes utifra hvilke argumenter
        // som matcher metoden med samme sett
        // med parametere
        person.sayWords("One");
        person.sayWords("One", "Two");
        person.sayWords("One", "Two", "Three");
        person.sayWords("One", "Two", "Three", "Four");
    }
}
