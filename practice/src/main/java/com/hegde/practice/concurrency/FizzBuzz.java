package com.hegde.practice.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore numSemaphore = new Semaphore(1);
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private AtomicInteger counter = new AtomicInteger(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            fizzSemaphore.acquire();
            int i = counter.get();
            if(i > n)
                break;
            if(i % 3 == 0 && i % 5 != 0){
                printFizz.run();
                numSemaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            buzzSemaphore.acquire();
            int i = counter.get();
            if(i > n)
                break;
            if(i % 3 != 0 && i % 5 == 0){
                printBuzz.run();
                numSemaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            fizzBuzzSemaphore.acquire();
            int i = counter.get();
            if(i > n)
                break;
            if(i % 3 == 0 && i % 5 == 0){
                printFizzBuzz.run();
                numSemaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++){
            numSemaphore.acquire();
            counter.set(i);

            if(i % 3 == 0 && i % 5 == 0){
                fizzBuzzSemaphore.release();
            }else if(i % 3 == 0 && i % 5 != 0){
                fizzSemaphore.release();
            }else if(i % 3 != 0 && i % 5 == 0){
                buzzSemaphore.release();
            }else{
                printNumber.accept(i);
                numSemaphore.release();
            }
        }
        //Making sure the last thread is completing it's work.
        // Otherwise this thread may not wait for other threads to complete.
        numSemaphore.acquire();
        counter.set(n+1);
        fizzSemaphore.release();
        buzzSemaphore.release();
        fizzBuzzSemaphore.release();
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number(x -> System.out.print(x + " "));
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        // start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // wait for completion
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nDone!");
    }
}
