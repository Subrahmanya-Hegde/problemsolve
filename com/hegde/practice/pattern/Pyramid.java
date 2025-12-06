package com.hegde.practice.pattern;

public class Pyramid {

    public static void printPyramid(int depth){
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < (depth - i - 1); j++){
                System.out.print(" ");
            }
            for(int j = 0; j < 2 * i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        printPyramid(5);
    }
}
