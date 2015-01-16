package com.example.exercises.fizz;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by phillip.heenan on 14/01/15.
 */
public class FizzBuzTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
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
    public void tesNotMultiple() {
        FizzBuzz f = new FizzBuzz();
        assertFalse(f.isMultiple(3, 5));
    }

    public void testExceptionThrown(){
        FizzBuzz f = new FizzBuzz();
        assertFalse(f.isMultiple(0, 3));
    }

    public void testPrinterNotMultiple() {
        FizzBuzz f = new FizzBuzz();
        assertEquals("1", f.print(1));
    }

    public void testPrinterMultiple3() throws Exception {
        FizzBuzz f = new FizzBuzz();
        assertEquals("Fizz", f.print(3));
    }

    public void testPrinterMultiple5() throws Exception {
        FizzBuzz f = new FizzBuzz();
        assertEquals("Buzz", f.print(5));
    }

    public void testPrinterMultiple3And5() throws Exception {
        FizzBuzz f = new FizzBuzz();
        assertEquals("FizzBuzz", f.print(15));
    }
}
