package com.example.exercises.anagram;

import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

/**
 * Created by phillip.heenan on 02/02/15.
 */
public class AnagramTest extends TestCase {

    String input = "crepitus"; // count of 5
    String input2 = "Sazironian"; // count of 2 - "Arizonian's", "Arizonians"
    String input3 = "Ariège"; // count of 1 - "Aèrige"

    Anagram anagram;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        anagram = new Anagram();


    }

    public void testCrepitus() {
        List<String> result = anagram.find(input);
        assertEquals(5, result.size());

    }

}
