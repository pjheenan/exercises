package com.example.exercises.fizz;

/**
 * Write a program that prints the numbers from 1 to 100. But for multiples of three getOutput "Fizz"
 * instead of the number and for the multiples of five getOutput "Buzz". For numbers which are multiples of both
 * three and five getOutput "FizzBuzz".
 *
 * Created by phillip.heenan on 14/01/15.
 */
public class FizzBuzz {

    public String[] runProgram(int max) {
        String[] result = new String[max];
        for(int i = 0; i < max; i++){
            result[i] = String.valueOf(getOutput(i+1));

        }
        return result;
    }

    protected Object getOutput(int number){
        String builder = new StringBuilder(isMultiple(3, number)? "Fizz": "")
                .append(isMultiple(5, number)? "Buzz" : "").toString();
        return (builder.length()!= 0) ? builder : number;
    }

    protected boolean isMultiple(int multiplier, int input){
        return multiplier > 0 && input % multiplier == 0;
    }
}