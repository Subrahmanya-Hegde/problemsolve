package com.hegde.practice.multithreading;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumOfNNumbers {

    private static final int THREADS = 8;
    static ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public static long calculateDistanceBetweenCoordinates(List<Integer> numbers) {
        LocalDateTime startTime = LocalDateTime.now();
        long totalSum = 0;
        List<Future<Long>> futures = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) numbers.size() / THREADS);
        for (int i = 0; i < THREADS; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, numbers.size());
            Callable<Long> sumCalculator = new SumCalculator(numbers, start, end);
            Future<Long> future = executorService.submit(sumCalculator);
            futures.add(future);
        }


        for (Future<Long> future : futures) {
            try {
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("It took " + Duration.between(startTime, endTime).toMillis() + " milli seconds");
        executorService.shutdown();
        return totalSum;
    }

    public static class SumCalculator implements Callable<Long> {
        private final List<Integer> numbers;
        private final int from;
        private final int to;

        public SumCalculator(List<Integer> numbers, int from, int to) {
            this.from = from;
            this.to = to;
            this.numbers = numbers;
        }

        @Override
        public Long call() throws Exception {
            System.out.println("Sums is being calculated in : " + Thread.currentThread().getName() + " from : " + from + " to : " + to);
            long sum = 0L;
            for (int i = from; i < to; i++) {
                sum += this.numbers.get(i);
            }
            return sum;
        }
    }
}
