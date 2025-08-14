package concurrency.threadingproblems;

class Deadlock {

    public static void main(String[] args) {
        go();
    }

    private static void go() {
        final String ransom = "ransom";
        final String hostage = "hostage";


        // having the locks in the same order prevents this deadlock
        Thread criminals = new Thread(() -> {
           synchronized (hostage) {
               System.out.println("The criminals have the hostage and want the ransom");

               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

               synchronized (ransom) {
                   System.out.println("The criminals have BOTH");
               }
           }
        });

        Thread police = new Thread(() -> {
            synchronized (ransom) {
                System.out.println("The police have the ransom and want the hostage");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (hostage) {
                    System.out.println("The police have BOTH");
                }
            }
        });

        criminals.start();
        police.start();
    }
}
