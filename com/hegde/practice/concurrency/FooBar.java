package com.hegde.practice.concurrency;

import java.util.concurrent.Semaphore;

/**
 * Semaphore(1) - Meaning we are allowing the 1 thread to allow to access the code block
 * We can control number of threads which can access the code block by passing the desired value here.
 * acquire() will decrement it and release will increase it. When this value reaches 0,
 * then rest of the threads need to wait till some thread releases the lock.
 * Some good ways to use semaphore -
 * <li>
 *      We can try use semaphore.tryAcquire() in if condition and handle the request gracefully.
 *      May be by throwing some exception. Or we can use tryAcquire(long timeout, TimeUnit unit) to make the thread
 *      wait for sometime and then handle the condition.
 * </li>
 * <li>
 *     availablePermits() - This shows how many permits are available. This can be used for debugging.
 * </li>
 * <li>
 *     drainPermits() - This can be used to acquire all locks. This will block all threads from accessing the code.
 *     Ex - If we are using semaphore in client level ratelimitting, may be if the we can use this to
 *     block the threads from accessing the API call function, when there is an outage on downstream side.
 *     We can release it when the service is UP. Circuit open and close.
 * </li>
 * <li>
 *     Semaphore(n, true) - Fairness. By default, it is false. Meaning lock is based on
 *     first come first servce basis. Whichever the thread comes first, it gets the lock.
 *     Otherwise it will be random.
 * </li>
 */
class FooBar {
    private final int n;

    private final Semaphore fooSemaphore = new Semaphore(1);
    private final Semaphore barSemaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nDone!");
    }
}
