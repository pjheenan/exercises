package com.example.exercises.fizz;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by phillip.heenan on 14/01/15.
 */
public class FizzBuzTest extends TestCase {

    Map<Integer, String> map;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        map = getIntegerStringMap();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testMultiple() {
        FizzBuzz f = new FizzBuzz();
        assertTrue(f.isMultiple(3, 6));
    }

    @Test
    public void testNotMultiple() {
        FizzBuzz f = new FizzBuzz();
        assertFalse(f.isMultiple(3, 5));
    }

    public void testExceptionThrown() {
        FizzBuzz f = new FizzBuzz();
        assertFalse(f.isMultiple(0, 3));
    }

    public void testPrinterNotMultiple() {
        FizzBuzz f = new FizzBuzz();
        assertEquals(1, f.getOutput(1, map));
    }

    public void testPrinterMultiple3() throws Exception {
        FizzBuzz f = new FizzBuzz();
        assertEquals("Fizz", f.getOutput(3, map));
    }

    public void testPrinterMultiple5() throws Exception {
        FizzBuzz f = new FizzBuzz();
        assertEquals("Buzz", f.getOutput(5, map));
    }

    public void testPrinterMultiple3And5() throws Exception {
        FizzBuzz f = new FizzBuzz();
        assertEquals("FizzBuzz", f.getOutput(15, map));
    }

    public void testRunProgram100() throws Exception {
        FizzBuzz f = new FizzBuzz();
        String[] result = f.runProgram(100, map);
        assertEquals(100, result.length);
        assertEquals("1", result[0]);
        assertEquals("Buzz", result[99]);
    }

    private Map<Integer, String> getIntegerStringMap() {
        map = new HashMap<Integer, String>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        return map;
    }

}
