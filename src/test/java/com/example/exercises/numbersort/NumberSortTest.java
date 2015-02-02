package com.example.exercises.numbersort;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @GIVEN   a new lottery drawer
 * @WHEN    a number is drawn from the bucket and added to the results
 * @THEN    the results should be returned sorted in ascending order
 *
 * Created by phillip.heenan on 26/01/15.
 */
public class NumberSortTest extends TestCase {

    NumberSort sorter;
    Random r = new Random();
    int Low = 1;
    int High = 1000;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        sorter = new NumberSort();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAcceptance() throws Exception{
        List<Integer> result = sorter.numberDraw(1);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1, (int)result.get(0));

        result = sorter.numberDraw(15);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, (int)result.get(0));
        assertEquals(15, (int)result.get(1));

        result = sorter.numberDraw(5);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(1, (int)result.get(0));
        assertEquals(5, (int)result.get(1));
        assertEquals(15, (int)result.get(2));

        result = sorter.numberDraw(23);
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(1, (int)result.get(0));
        assertEquals(5, (int)result.get(1));
        assertEquals(15, (int)result.get(2));
        assertEquals(23, (int)result.get(3));
    }

    public void testAddLower() throws Exception{
        sorter.add(3);
        assertNotNull(sorter.numbers);
        assertEquals(1, sorter.numbers.size());
        assertEquals(3, (int)sorter.numbers.get(0));

        sorter.add(1);
        assertEquals(2, sorter.numbers.size());
        assertEquals(3, (int)sorter.numbers.get(1));
    }

    public void testAddGreater() throws Exception{
        sorter.add(1);
        assertNotNull(sorter.numbers);
        assertEquals(1, sorter.numbers.size());
        assertEquals(1, (int)sorter.numbers.get(0));

        sorter.add(3);
        assertEquals(2, sorter.numbers.size());
        assertEquals(1, (int)sorter.numbers.get(0));
        assertEquals(3, (int)sorter.numbers.get(1));
    }

    public void testSequence() {
        sorter.add(15);
        sorter.add(5);
        sorter.add(20);
        sorter.add(7);
        sorter.add(30);

        assertEquals(5, (int)sorter.numbers.get(0));
        assertEquals(7, (int)sorter.numbers.get(1));
        assertEquals(15, (int)sorter.numbers.get(2));
        assertEquals(20, (int)sorter.numbers.get(3));
        assertEquals(30, (int)sorter.numbers.get(4));

    }

    public void testRandom() {
        List<Integer> result = null;
        for(int i = 0; i < 100; i++) {
            int input = getRandomInput();
//            System.out.println("adding input: " + input);
            result = sorter.numberDraw(input);
        }

        // validate result array
        int previous = result.get(0);
        for (int j = 1; j < result.size(); j++) {
            System.out.println("previous: " + previous + " compared to " + result.get(j));
            assertTrue("not sorted: previous: " + previous + " is greater than next: " + result.get(j), result.get(j) >= previous);
            previous = result.get(j);
        }
    }

    public void testSortingMultiple() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(50, 60, 30, 70, 20, 80));
        List<Integer> result = null;
        for (int value : input) {
            result = sorter.numberDraw(value);
        }

        assertNotNull(result);
        assertEquals(6, result.size());
        assertEquals(new Integer(20), result.get(0));
        assertEquals(new Integer(30), result.get(1));
        assertEquals(new Integer(50), result.get(2));
        assertEquals(new Integer(60), result.get(3));
        assertEquals(new Integer(70), result.get(4));
        assertEquals(new Integer(80), result.get(5));

    }

    private int getRandomInput() {
        return r.nextInt(High-Low) + Low;
    }
}