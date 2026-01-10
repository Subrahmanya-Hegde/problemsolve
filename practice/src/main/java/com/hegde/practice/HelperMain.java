package com.hegde.practice;

import com.hegde.practice.lld.SlidingWindowRateLimiting;

public class HelperMain {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiting rateLimiter = new SlidingWindowRateLimiting(3, 1000);
        for(int i = 0; i < 1000; i++){
            if(rateLimiter.allow("foo")){
                System.out.println("Foo Hit");
            }else {
                System.out.println("Foo miss");
            }
            if(rateLimiter.allow("bar")){
                System.out.println("Bar hit");
            }else {
                System.out.println("Bar miss");
            }
            if(i % 100 == 0){
                Thread.sleep(1000);
            }
        }
    }
}