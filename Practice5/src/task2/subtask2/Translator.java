package task2.subtask2;

import java.util.*;

public class Translator {
    private HashMap<String, String> dictionary;

    public Translator() {
        dictionary = new HashMap<>();
    }

    public void addPair(String english, String russian) {
        dictionary.put(english.toLowerCase(), russian.toLowerCase());
    }

    public String translate(String phrase) {
        String[] words = phrase.toLowerCase().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : words) {
            stringBuilder.append(dictionary.getOrDefault(word, word) + " ");
        }
        return stringBuilder.toString();
    }
}