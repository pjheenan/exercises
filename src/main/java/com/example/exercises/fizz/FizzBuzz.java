package com.example.exercises.fizz;

/**
 * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz"
 * instead of the number and for the multiples of five print "Buzz". For numbers which are multiples of both
 * three and five print "FizzBuzz".
 *
 * Created by phillip.heenan on 14/01/15.
 */
public class FizzBuzz {

    protected String print(int number){
        StringBuilder builder = new StringBuilder();
        if(isMultiple(3, number)){
            builder.append("Fizz");
        }
        if (isMultiple(5, number)){
            builder.append("Buzz");
        }
        return (builder.length()!= 0) ? builder.toString() : String.valueOf(number);
    }



    protected boolean isMultiple(int multiplier, int input){
        boolean result = false;
        try {
            result = input % multiplier == 0;
        }catch (ArithmeticException e){
            // Dividing by 0
        }
        return result;
    }
}
