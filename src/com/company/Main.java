package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(1000);
        BankAccount bankAccount2 = new BankAccount(2000);

        // Deadlock will occur
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bankAccount1){
                    System.out.println("bankAccount1 locked by the first thread");
                    try{
                        bankAccount1.withdraw(500);
                    } catch (Exception e) {

                    }
                    System.out.println("First thread waiting for bankAccount2 to be released");
                    synchronized (bankAccount2){
                        try {
                            bankAccount1.withdraw(500);
                            System.out.println("bankAccount1 and bankAccount2 locked by the first thread");
                        } catch (Exception e){

                        }
                    }
                }
                System.out.println("Both bankAccounts released by the first Thread");
            }
        }).start();

        System.out.println("Balance of bankAccount1: " + bankAccount1.getBalance());

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bankAccount2){
                    System.out.println("bankAccount2 locked by the second thread");
                    try{
                        bankAccount1.withdraw(500);
                    } catch (Exception e) {

                    }
                    System.out.println("Second thread waiting for bankAccount1 to be released");
                    synchronized (bankAccount1){
                        try {
                            bankAccount1.withdraw(500);
                            System.out.println("bankAccount2 and bankAccount1 locked by the second thread");
                        } catch (Exception e){

                        }
                    }
                }
                System.out.println("Both bankAccounts released by the second Thread");
            }
        }).start();


        System.out.println("Balance of bankAccount2: " + bankAccount2.getBalance());
    }

}
