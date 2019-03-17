package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable{

    private int count = 1;
    private String threadColor;
    private ReentrantLock lock;

    public Counter(String threadColor, ReentrantLock lock) {
        this.threadColor = threadColor;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.format(threadColor + "%s: count = %d\n", Thread.currentThread().getName(), count++);
            } finally {
                lock.unlock();
            }

        }
    }
}
