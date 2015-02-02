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
 * Created by phillip.heenan on 02/02/15.
 */
public class Anagram {

    public List<String> find(String word) {
        List<String> dictionary = getDictionary();

        List<String> result = new ArrayList<String>();

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
