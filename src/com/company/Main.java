package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    //true in the Reentrantlock constructor means that the lock will be a fair lock (FIFO kind)
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        /*
        // Deadlock will occur
        BankAccount bankAccount1 = new BankAccount(1000);
        BankAccount bankAccount2 = new BankAccount(10000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bankAccount1) {
                    System.out.println("bankAccount1 locked by the first thread");
                    try {
                        bankAccount1.withdraw(500);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("First thread waiting for bankAccount2 to be released");
                    synchronized (bankAccount2) {
                        try {
                            bankAccount2.withdraw(500);
                            System.out.println("bankAccount1 and bankAccount2 locked by the first thread");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.println("Both bankAccounts released by the first Thread");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bankAccount2) {
                    System.out.println("bankAccount2 locked by the second thread");
                    try {
                        bankAccount2.withdraw(500);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Second thread waiting for bankAccount1 to be released");
                    synchronized (bankAccount1) {
                        try {
                            bankAccount1.withdraw(500);
                            System.out.println("bankAccount2 and bankAccount1 locked by the second thread");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.println("Both bankAccounts released by the second Thread");
            }
        }).start();

    */

    // Reentrant lock usage example
        Thread thread1 = new Thread(new Counter(ThreadColor.ANSI_BLUE, lock),"Priority 10");
        Thread thread2 = new Thread(new Counter(ThreadColor.ANSI_GREEN, lock),"Priority 6");
        Thread thread3 = new Thread(new Counter(ThreadColor.ANSI_RED, lock),"Priority 4");
        Thread thread4 = new Thread(new Counter(ThreadColor.ANSI_PURPLE, lock),"Priority 2");

        thread1.setPriority(10);
        thread2.setPriority(6);
        thread3.setPriority(4);
        thread4.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    //Live lock example -> threads are active (e.g. looping) while waiting for other threads to finish
    /*
        final Worker worker1 = new Worker("Worker 1", true);
    final Worker worker2 = new Worker("Worker 2", true);

    final SharedResource sharedResource = new SharedResource(worker1);

    new Thread(new Runnable() {
        @Override
        public void run() {
            worker1.work(sharedResource, worker2);
        }
    }).start();

    new Thread(new Runnable() {
        @Override
        public void run() {
            worker2.work(sharedResource, worker2);
        }
    }).start();

     */
    }

}
