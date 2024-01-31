package solutions._04.extra;

import java.util.ArrayList;

public class Program
{
    public void runProgram() {
        System.out.println("Programmet starter ...");

        ArrayList<Word> words = new ArrayList<>();

        Word happy = new Word("happy");
        Word joyful = new Word("joyful");

        happy.addSynonym(joyful);

        Word smart = new Word("smart");
        Word intelligent = new Word("intelligent");
        Word wise = new Word("wise");

        smart.addSynonym(intelligent);
        smart.addSynonym(wise);

        words.add(happy);
        words.add(smart);

        for (Word word : words) {
            System.out.println("----");
            System.out.println("Word:");
            System.out.println("- " + word.getWord());

            System.out.println("Synonyms:");
            for (Word synonym : word.getSynonyms()) {
                System.out.println("- " + synonym.getWord());
            }
        }
    }
}
