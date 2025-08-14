package concurrency.threadingproblems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int balance) {
        this.balance -= balance;
    }
}

class RaceCondition implements Runnable {
    public static Lock lock = new ReentrantLock();

    private final BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) {
        Runnable runnable = new RaceCondition();
        Thread john = new Thread(runnable);
        Thread mary = new Thread(runnable);
        john.setName("John");
        mary.setName("Mary");
        john.start();
        mary.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            makeWithdrawal(10);
            if(bankAccount.getBalance() < 0) {
                System.out.println("Account is overdrawn!");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    private void makeWithdrawal(int amtToWithdrawal) {
//      private synchronized void makeWithdrawal(int amtToWithdrawal) {
//
//        if(bankAccount.getBalance() >= amtToWithdrawal) {
//            System.out.printf("%s - Balance BEFORE: %s%n", Thread.currentThread().getName(), bankAccount.getBalance());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            bankAccount.withdraw(amtToWithdrawal);
//            System.out.printf("%s - Balance AFTER: %s%n", Thread.currentThread().getName(), bankAccount.getBalance());
//        } else {
//            System.out.printf("%s is unable to withdrawal as balance is: %s%n", Thread.currentThread().getName(), bankAccount.getBalance());
//        }
//
//    }

    private void makeWithdrawal(int amtToWithdrawal) {
        try {
            lock.lock();
            if(bankAccount.getBalance() >= amtToWithdrawal) {
                System.out.printf("%s - Balance BEFORE: %s%n", Thread.currentThread().getName(), bankAccount.getBalance());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                bankAccount.withdraw(amtToWithdrawal);
                System.out.printf("%s - Balance AFTER: %s%n", Thread.currentThread().getName(), bankAccount.getBalance());
            } else {
                System.out.printf("%s is unable to withdrawal as balance is: %s%n", Thread.currentThread().getName(), bankAccount.getBalance());
            }
        } finally {
            lock.unlock();
        }
    }
}
