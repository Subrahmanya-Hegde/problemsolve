package com.hegde.practice.arrays;

public class NonDuplicateInArray {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 2, 2, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6};
        printNonDuplicate(array);
    }

    private static void printNonDuplicate(int[] array){
        int length = array.length;
        int indexToBeUpdated = 0;
        for(int i = 0; i < length - 1; i++){
            array[indexToBeUpdated++] = array[i];
            if(array[i] == array[i + 1]) {
                for(int j = i + 1; j < length; j++) {
                    if (array[j] != array[j + 1]){
                        i = j;
                        break;
                    }
                }
            }
        }
        if(array[length - 2] != array[length - 1])
            array[indexToBeUpdated] = array[length - 1];

        for(int i = indexToBeUpdated + 1; i < length; i++)
            array[i] = 0;

        for(int num : array)
            System.out.print(num + " ");
    }
}