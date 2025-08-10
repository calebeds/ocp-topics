package concurrency.threadcreation;


class Countdown implements Runnable {
    String[] timeString = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    @Override
    public void run() {
        for (int i = 9; i >= 0; i--) {
            try {
                System.out.println(timeString[i]);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class TimeBomb {
    public static void main(String[] args) throws InterruptedException {
        Thread timer = new Thread(new Countdown());
        System.out.println("Starting 10 seconds count down...");
        timer.start();
        timer.join();
        System.out.println("Boom!!");
    }
}
