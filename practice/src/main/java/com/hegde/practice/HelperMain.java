package com.hegde.practice;

import com.hegde.practice.string.Cesar;

import static com.hegde.practice.greedy.HandOfStraights.isNStraightHand;

public class HelperMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(isNStraightHand(new int[]{1,2,4,2,3,5,3,4}, 4));
    }
}