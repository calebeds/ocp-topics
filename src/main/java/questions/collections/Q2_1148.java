package questions.collections;

import java.util.ArrayDeque;
import java.util.Deque;

class Q2_1148 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.offerLast(2);
        deque.push(3);
        deque.peekFirst();
        deque.removeLast();
        deque.pop();
        System.out.println(deque);
    }
}
