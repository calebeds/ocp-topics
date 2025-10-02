package questions.collections;

import java.util.ArrayDeque;
import java.util.Deque;

class Q2_1131 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
    }
}
