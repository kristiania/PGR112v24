package solutions._04;

import java.util.ArrayList;


public class Word
{
    //# Fields
    private String data;
    private ArrayList<String> synonyms;

    //# Constructor
    public Word(String word) {
        this.data = word;
        this.synonyms = new ArrayList<>();
    }

    //# Getters
    public String getWord() {
        return this.data;
    }

    public ArrayList<String> getSynonyms() {
        return this.synonyms;
    }

    //# Methods
    public void addSynonym(String word) {
        this.synonyms.add(word);
    }
}
