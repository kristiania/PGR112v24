package solutions._04.extra;

import java.util.ArrayList;


public class Word
{
    //# Fields
    private String data;
    private ArrayList<Word> synonyms;

    //# Constructor
    public Word(String word) {
        this.data = word;
        this.synonyms = new ArrayList<>();
    }

    //# Getters
    public String getWord() {
        return this.data;
    }

    public ArrayList<Word> getSynonyms() {
        return this.synonyms;
    }

    //# Methods
    public void addSynonym(Word word) {
        this.synonyms.add(word);
    }
}

