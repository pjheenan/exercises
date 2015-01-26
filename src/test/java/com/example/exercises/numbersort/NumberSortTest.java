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

    public void testAdd() throws Exception{
        sorter.add(3);
        assertNotNull(sorter.numbers);
        assertEquals(1, sorter.numbers.size());
        assertEquals(1, (int)sorter.numbers.get(0));

        sorter.add(1);
        assertEquals(2, sorter.numbers.size());
        assertEquals(3, (int)sorter.numbers.get(1));
    }

    public void testIntCompare() throws Exception{
        int result = sorter.compare(1, 3);
        assertEquals(1, result);

        result = sorter.compare(3, 1);
        assertEquals(-1, result);

        result = sorter.compare(1, 1);
        assertEquals(0, result);
    }

//    public void testRandom() {
//
//        for(int i = 0; i < 100; i++) {
//            int input = getRandomInput();
//            System.out.println("adding input: " + input);
//            // TODO add random result to NumberSort
//            sorter.add(input);
//        }
//
//        // TODO populate result
//        Integer[] result = null;
//
//        // validate result array
//        int previous = result[0];
//        for (int j = 1; j < result.length; j++) {
//            System.out.println("previous: " + previous + " compared to " + result[j]);
//            assertTrue("not sorted: previous: " + previous + " is greater than next: " + result[j], result[j] >= previous);
//            previous = result[j];
//        }
//    }
//
//    public void testSortingMultiple() {
//        List<Integer> input = new ArrayList<Integer>(Arrays.asList(50, 60, 30, 70, 20, 80));
//        sorter.numbers
//
//        // TODO populate result set
//        Integer[] result = null;
//
//        assertNotNull(result);
//        assertEquals(6, result.length);
//        assertEquals(new Integer(20), result[0]);
//        assertEquals(new Integer(30), result[1]);
//        assertEquals(new Integer(50), result[2]);
//        assertEquals(new Integer(60), result[3]);
//        assertEquals(new Integer(70), result[4]);
//        assertEquals(new Integer(80), result[5]);
//
//    }

    private int getRandomInput() {
        return r.nextInt(High-Low) + Low;
    }
}