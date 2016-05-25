package com.example.exercises.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Search the dictionary list for anagrams of a selected word.
 * The result should not include the word itself.
 *
 * Created by phillip.heenan on 02/02/15.
 */
public class Anagram {

    public List<String> find(String word) {
        List<String> dictionary = getDictionary();
        List<String> result = new ArrayList<String>();
        int count =0;
        for (String wordFromDictionary : dictionary) {
            if (wordFromDictionary.length() == word.length()) {
                for (int i=0 ; i < word.length(); i++){
                    wordFromDictionary.
                    if (wordFromDictionary.contains(String.valueOf(word.charAt(i)))) {
                        count++;
                    }
                }
                if (count == word.length()) {
                    result.add(wordFromDictionary);
                    System.out.println(wordFromDictionary);
                }
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

}
