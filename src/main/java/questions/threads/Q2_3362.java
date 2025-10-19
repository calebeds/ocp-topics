package questions.threads;

import java.util.concurrent.locks.ReentrantLock;

class Account {
    private String id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(double amt) {
        try {
            lock.lock();
            if(balance > amt) {
                balance = balance - amt;
            }
        } finally {
            lock.unlock();
        }
    }
}

class Q2_3362 {
    public static void main(String[] args) {
        Account account = new Account();
        Thread thread1 = new Thread(() -> account.withdraw(10));
        thread1.start();
        Thread thread2 = new Thread(() -> account.withdraw(20));
        thread2.start();
    }
}
