package collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class ComparatorIsUseful {
    public static void main(String[] args) {
//        Set<Boss> bosses = new TreeSet<>();
//        bosses.add(new Boss(20));
//        bosses.add(new Boss(10));
//        bosses.add(new Boss(15));
//        System.out.println(bosses);

//        Set<Worker> workers = new TreeSet<>();
//        Set<Worker> workers = new TreeSet<>((worker1, worker2) -> worker1.getId() - worker2.getId());
//        Set<Worker> workers = new TreeSet<>(Comparator.comparing(worker -> worker.getId()));
        Set<Worker> workers = new TreeSet<>(Comparator.comparing(Worker::getId)); // unbound method reference

        workers.add(new Worker(30));
        workers.add(new Worker(20));
        workers.add(new Worker(10));
        workers.add(new Worker(11));
        System.out.println(workers);
    }


    static class Worker {
        private int id;

        public Worker(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "id=" + id +
                    '}';
        }
    }

    static class Boss implements Comparable<Boss> {
        private int id;

        public Boss(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Boss otherBoss) {
            return this.id - otherBoss.getId();
        }
    }
}
