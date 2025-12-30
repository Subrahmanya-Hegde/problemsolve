package com.hegde.practice.arrays;


import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int left, int right){

        if(left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tempArray = new ArrayList<>();
        int leftIterator = low;
        int rightIterator = mid + 1;

        while (leftIterator <= mid && rightIterator <= high){
            if(arr[leftIterator] <= arr[rightIterator]){
                tempArray.add(arr[leftIterator]);
                leftIterator++;
            }else {
                tempArray.add(arr[rightIterator]);
                rightIterator++;
            }
        }

        while (leftIterator <= mid){
            tempArray.add(arr[leftIterator++]);
        }

        while (rightIterator <= mid){
            tempArray.add(arr[rightIterator++]);
        }

        for(int i = low; i <= high; i++){
            arr[i] = tempArray.get(i - low);
        }
    }
}
