package questions.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Student {
    private Map<String, Integer> marksObtained = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void setMarksInSubject(String subject, Integer marks) {
        lock.writeLock().lock();
        try {
            marksObtained.put(subject, marks);
        } finally {
            lock.writeLock().unlock();;
        }
    }

    public double getAverageMarks() {
        lock.readLock().lock();
        double sum = 0.0;
        try {
            for (Integer mark : marksObtained.values()) {
                sum += mark;
            }

            return sum / marksObtained.size();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        final Student student = new Student();

        // create one thread that keeps adding marks
        new Thread(() -> {
           int x = 0;
           while (true) {
               int m = (int) (Math.random() * 100);
               student.setMarksInSubject(" Sub " + x, m);
               x++;
           }
        }).start();

        // create 5 threads that get average marks
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    double avg = student.getAverageMarks();
                    System.out.println(avg);
                }
            }).start();
        }
    }
}

class Q2_1104 {

}
