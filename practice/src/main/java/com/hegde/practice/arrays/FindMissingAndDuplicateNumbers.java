package com.hegde.practice.arrays;

public class FindMissingAndDuplicateNumbers {

    public static void findMissingAndDuplicateNumbers(int[] array, int size) {

        for (int i = 0; i < size; i++) {
            int indexToUpdate = (array[i] - 1) % size;
            if (array[indexToUpdate] > size) {
                System.out.println("Duplicate Number is :" + (indexToUpdate + 1));
            }
            array[indexToUpdate] += size;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] <= size) {
                System.out.println("Missing Number is " + (i + 1));
                break;
            }
        }
    }
}
