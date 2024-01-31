package solutions._04;

import java.util.ArrayList;

public class Program
{
    public void runProgram() {
        System.out.println("Programmet starter ...");

        ArrayList<Word> words = new ArrayList<>();

        Word happy = new Word("happy");
        happy.addSynonym("joyful");

        Word smart = new Word("smart");
        smart.addSynonym("intelligent");
        smart.addSynonym("wise");

        words.add(happy);
        words.add(smart);

        for (Word word : words) {
            System.out.println("Word:");
            System.out.println("- " + word.getWord());

            System.out.println("Synonyms:");
            for (String synonym : word.getSynonyms()) {
                System.out.println("- " + synonym);
            }
        }
    }
}
