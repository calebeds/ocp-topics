package concurrency.threadsafefy;

class DataRace {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> addToCounter()).start();
        }
    }

    private static void addToCounter() {
        int c = count;
        System.out.printf("Before: %s | Thread id: %s %n", count, Thread.currentThread().getId());
        count = c + 1;
        System.out.printf("After: %s | Thread id: %s %n", count, Thread.currentThread().getId());
    }
}
