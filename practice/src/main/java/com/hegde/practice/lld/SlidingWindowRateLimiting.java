package com.hegde.practice.lld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SlidingWindowRateLimiting {

    int rate;
    int windowMillis;
    ConcurrentMap<String, Deque<Long>> requestsBucket;

    public SlidingWindowRateLimiting(int rate, int windowMillis){
        requestsBucket = new ConcurrentHashMap<>();
        this.rate = rate;
        this.windowMillis = windowMillis;
    }

    public boolean allow(String key){
        final var currentTimeInSeconds = System.currentTimeMillis();
        final var windowStart = currentTimeInSeconds - windowMillis;
        var requests = requestsBucket.computeIfAbsent(key, k -> new ArrayDeque<>());
        synchronized (requests){
            while (!requests.isEmpty() && requests.peek() < windowStart){
                requests.pollFirst();
            }
            if(requests.size() >= rate){
                return false;
            }
            requests.addLast(currentTimeInSeconds);
            return true;
        }
    }
}
