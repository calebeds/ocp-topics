package concurrency.threadsafefy;

class FixDataRaceWithSynchronized {
    private static int count = 0;

//    public static void addToCounter() {
////        synchronized (FixDataRaceWithSynchronized.class) {
//            int c = count;
//            System.out.printf("Before: %s | Thread id: %s %n", count, Thread.currentThread().getId());
//            count = c + 1;
//            System.out.printf("After: %s | Thread id: %s %n", count, Thread.currentThread().getId());
////        }
//    }

    public synchronized void addToCounter() {
//        synchronized (this) {
            int c = count;
            System.out.printf("Before: %s | Thread id: %s %n", count, Thread.currentThread().getId());
            count = c + 1;
            System.out.printf("After: %s | Thread id: %s %n", count, Thread.currentThread().getId());
//        }
    }

    public static void main(String[] args) {
        FixDataRaceWithSynchronized instance = new FixDataRaceWithSynchronized();
        for (int i = 0; i <= 10; i++) {
//            new Thread(() -> addToCounter())
            new Thread(() -> instance.addToCounter())
                    .start();
        }
    }
}
