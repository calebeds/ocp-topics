package concurrency.threadcreation;

class CreateUsingLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("run(): " + Thread.currentThread().getName()));

        thread.start();
//        thread.run(); // using run directly doesn't start the other thread
        System.out.println("main(): " + Thread.currentThread().getName());
    }
}
