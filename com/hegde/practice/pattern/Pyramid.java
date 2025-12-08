package com.hegde.practice.pattern;

public class Pyramid {

    public static void printPyramid(int depth){
        for(var i = 0; i < depth; i++){
            for(var j = 0; j < (depth - i - 1); j++){
                printSpace();
            }
            for(var j = 0; j < 2 * i + 1; j++){
                printStar();
            }
            System.out.println();
        }

    }

    public static void printReversePyramid(int depth){
        for(var i = depth - 1; i >= 0; i--){
            for(int j = 0; j < (depth - i - 1); j++){
                printSpace();
            }
            for(var j = 0; j < 2 * i + 1; j++){
                printStar();
            }
            for(var j = 0; j < (depth - i - 1); j++){
                printSpace();
            }
            System.out.println();
        }
    }

    public static void printRightTiltedPyramid(int n){
        var depth = 2 * n;
        for(var i = 1; i < depth; i++){
            var starsToBePrinted = i > n ? depth - i : i;
            for(var j = 0; j < starsToBePrinted; j++){
                printStar();
            }
            System.out.println();
        }
    }

    public static void printOneZeroHalfPyramid(int n){
        var charToBePrinted = 1;
        for(var i = 0; i < n; i++){
            for(var j = 0; j <= i; j++){
                System.out.print(charToBePrinted);
                charToBePrinted ^= 1;
            }
            System.out.println();
        }
    }

    public static void printHalfAlphabetsPyramid(int n){
        var A = 97;
        for(var i = 0; i < n; i++){
            for(var j = 0; j <= i; j++){
                System.out.print((char) (A + j));
            }
            System.out.println();
        }
    }

    private static void printStar(){
        System.out.print("*");
    }

    private static void printSpace(){
        System.out.print(" ");
    }
}
