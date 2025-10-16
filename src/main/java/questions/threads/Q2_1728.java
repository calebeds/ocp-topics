package questions.threads;

class Q2_1728 {
    static class Runner implements Runnable {

        @Override
        public void run() {
            System.out.println("In Run");
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();

        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        thread1.start();
        thread2.start();
    }
}
