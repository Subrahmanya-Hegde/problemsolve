package com.hegde.practice.string;

import java.util.Arrays;

public class StringOperation {

    public static void main(String[] args){
        randomOperations();
    }

    public static void randomOperations(){

        String spaceSeparatedSentence = "abc efg  klm";
        String commaSeparatedSentence = "abc,efg,klm";
        String dotSeparatedSentence = "abc.efg.klm";
        String separatedSentence = "abc|efg|klm";


        printArray(spaceSeparatedSentence.split("\\s+"));
        printArray(commaSeparatedSentence.split(","));
        printArray(dotSeparatedSentence.split("\\."));
        printArray(separatedSentence.split("\\|"));
    }

    private static void printArray(String[] array){
        Arrays.stream(array).forEach(
                System.out::println
        );
    }

}
