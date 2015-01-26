package com.example.exercises.numbersort;

import java.util.ArrayList;
import java.util.List;

/**
 * In the Pragmatic Lottery (motto: There’s One Born Every Minute, and it Might Just Be You!), we select each week’s
 * winning combination by drawing balls. There are sixty balls, numbered (not surprisingly, as we are programmers) 0 to
 * 59. The balls are drawn by the personable, but somewhat distracted, Daisy Mae. As a result, some weeks five numbers
 * are drawn, while other weeks seven, nine, or even fifteen balls make it to the winner’s rack. Regardless of the number
 * of balls drawn, our viewers need to see the list of winning numbers in sorted order just as soon as possible. So, your
 * challenge is to come up with some code that accepts each number as it is drawn and presents the sorted list of numbers
 * so far.
 *
 * Created by phillip.heenan on 26/01/15.
 */
public class NumberSort {

    List<Integer> numbers;

    public NumberSort() {
        numbers = new ArrayList<Integer>();
    }

    public void add(int number) {
        numbers.add(number);
    }

}
