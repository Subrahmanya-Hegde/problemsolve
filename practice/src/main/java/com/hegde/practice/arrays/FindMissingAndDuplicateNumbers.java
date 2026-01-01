package com.hegde.practice.arrays;

/**
 * https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers
 * Approach: We add the size on indexToUpdate. Why? Because if we do that,
 * we end up adding size on the repeating number twice, so if we check if the current value is greater than
 * size while updating itself, we should get the repeating.
 *
 * And after adding the values, missing index will have value lesser than or equal to size.
 */
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
