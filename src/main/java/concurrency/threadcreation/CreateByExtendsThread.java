package concurrency.threadcreation;

class CreateByExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("run(): " + getName());
    }

    public static void main(String[] args) {
        new CreateByExtendsThread().start();
        System.out.println("main(): " + Thread.currentThread().getName());
    }
}
