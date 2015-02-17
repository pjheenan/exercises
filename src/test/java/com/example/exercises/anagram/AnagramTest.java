package com.example.exercises.anagram;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by phillip.heenan on 02/02/15.
 */
public class AnagramTest extends TestCase {

    Anagram anagram;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        anagram = new Anagram();

    }

    public void testDictionaryAnagram() {
        String input = "crepitus";
        Long start = System.currentTimeMillis();
        List<String> result = anagram.find(input);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        assertEquals(5, result.size());
    }

    public void testCounter() throws Exception {
        Map<Character, Integer> counts = anagram.getCounts("caar", false);
        assertNotNull(counts);
        assertEquals(3, counts.size());
        assertEquals(1, (int) counts.get('c'));
        assertEquals(2, (int) counts.get('a'));
        assertEquals(1, (int) counts.get('r'));
    }

    public void testNullWord() throws Exception {
        Map<Character, Integer> counts = anagram.getCounts(null, false);
        assertNotNull(counts);
        assertEquals(0, counts.size());
    }

    public void testEmptyWord() throws Exception {
        Map<Character, Integer> counts = anagram.getCounts("", false);
        assertNotNull(counts);
        assertEquals(0, counts.size());
    }

    public void testFindZeroResults() throws Exception {
        List<String> result = anagram.find("");
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    public void testFind() throws Exception{
        List<String> fakeDictionary = new ArrayList<String>();
        fakeDictionary.add("Ark");
        fakeDictionary.add("Spanner");
        fakeDictionary.add("Gym");
        fakeDictionary.add("Auk");
        anagram.dictionary = fakeDictionary;

        List<String> result = anagram.find("Ark");
        assertNotNull(result);
        assertEquals(0, result.size());
        assertFalse(result.contains("Ark"));
    }

    public void testAnagram() {
        List<String> fakeDictionary = new ArrayList<String>();
        fakeDictionary.add("Rak");
        anagram.dictionary = fakeDictionary;

        List<String> result = anagram.find("Ark");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Rak", result.get(0));
    }

    public void testAnagramNonAlpha() {
        List<String> fakeDictionary = new ArrayList<String>();
        fakeDictionary.add("Arizonian's");
        fakeDictionary.add("Arizonians");
        fakeDictionary.add("Spanner");
        fakeDictionary.add("Sazironian");
        fakeDictionary.add("Gym");
        fakeDictionary.add("Auk");
        anagram.dictionary = fakeDictionary;

        List<String> result = anagram.find("Sazironian");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Arizonian's"));
    }

    public void testAnagramAccented() {
        List<String> fakeDictionary = new ArrayList<String>();
        fakeDictionary.add("Ariège");
        fakeDictionary.add("Aèrige");
        fakeDictionary.add("Bokmål");
        fakeDictionary.add("Gym");
        fakeDictionary.add("Auk");
        anagram.dictionary = fakeDictionary;

        List<String> result = anagram.find("Ariège");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains("Aèrige"));
    }


}
