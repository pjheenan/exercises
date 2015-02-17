package com.example.exercises.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by phillip.heenan on 02/02/15.
 */
public class Anagram {

    List<String> dictionary;
    Set<Character> letters;

    public Anagram() {
        dictionary = getDictionary();
    }

    //TODO: beat performance: 156 - 164 ms, clean (248)

    public List<String> find(String word) {
        List<String> result = new ArrayList<String>();
        Map<Character, Integer> counts = getCounts(word, false);
        letters = counts.keySet();
        for(String value: dictionary){
            if(counts.equals(getCounts(value, true)) && !word.equals(value)){
                result.add(value);
            }
        }
        return result;
    }

    public Map<Character, Integer> getCounts (String word, boolean hasLetters){
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        if (word == null) {
            return result;
        }
        word = word.toLowerCase();
        for (char character : word.toCharArray()) {
            if (isAlphaCharacter(character)) {
                if (hasLetters && !letters.contains(character)) {
                    return null;
                }
                result.put(character, result.containsKey(character) ? result.get(character) + 1: 1);
            }
        }
        return result;
    }

    List<String> getDictionary() {
        InputStream is = getClass().getResourceAsStream("/wordlist.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        List<String> words = new ArrayList<String>();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    protected boolean isAlphaCharacter(char c) {
        return ('a' <= c && c <= 'z');
    }

}
