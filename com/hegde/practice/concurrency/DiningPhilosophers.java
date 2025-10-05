package com.hegde.practice.concurrency;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    Semaphore[] forks = new Semaphore[5];
    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++)
            forks[i] = new Semaphore(1);
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int right = (philosopher + 1) % 5;

        if (philosopher % 2 == 0) {
            forks[right].acquire();
            forks[philosopher].acquire();
        } else {
            forks[philosopher].acquire();
            forks[right].acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();

        forks[philosopher].release();
        forks[right].release();
    }

    public static void main(String[] args) {
        DiningPhilosophers dining = new DiningPhilosophers();

        for (int i = 0; i < 5; i++) {
            int philosopher = i;
            Thread t = new Thread(() -> {
                try {
                    for (int j = 0; j < 3; j++) {
                        dining.wantsToEat(
                                philosopher,
                                () -> System.out.println("Philosopher " + philosopher + " picked left fork"),
                                () -> System.out.println("Philosopher " + philosopher + " picked right fork"),
                                () -> {
                                    System.out.println("Philosopher " + philosopher + " is eating");
                                    try {Thread.sleep(300);} catch (InterruptedException ignored) {}
                                },
                                () -> System.out.println("Philosopher " + philosopher + " put down left fork"),
                                () -> System.out.println("Philosopher " + philosopher + " put down right fork")
                        );
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Philosopher-" + i);

            t.start();
        }
    }
}
