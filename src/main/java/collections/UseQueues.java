package collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class UseQueues {
    public static void main(String[] args) {
//        showLinkedListQueue();
//        showArrayDeque();
//        showPriorityQueueNaturalOrdering();
        showPriorityQueueDifferentOrdering();
    }

    private static void showLinkedListQueue() {
        Queue<Integer> linkedListQueue = new LinkedList<>();

        System.out.println("Inserting into the queue");

        System.out.println("1");
        linkedListQueue.add(1);
        System.out.println("Queue: " + linkedListQueue);
        System.out.println("2");
        linkedListQueue.offer(2);
        System.out.println("Queue: " + linkedListQueue);

        System.out.println("3");
        linkedListQueue.add(3);
        System.out.println("Queue: " + linkedListQueue);

        System.out.println("4");
        linkedListQueue.offer(4);
        System.out.println("Queue: " + linkedListQueue);

        System.out.println("Get the first element: ");
        System.out.println("Element method: " + linkedListQueue.element());
        System.out.println("Peek Method: " + linkedListQueue.peek());
        System.out.println("Queue: " + linkedListQueue);

        System.out.println("Remove Elements: ");
        System.out.println("Remove method: " + linkedListQueue.remove());
        System.out.println("Poll method: " + linkedListQueue.poll());
        System.out.println("Queue: " + linkedListQueue);

    }

    private static void showArrayDeque() {
        Deque<Integer> numbers = new ArrayDeque<>();

        System.out.println("Add to the front of the queue");
        System.out.println("1");
        numbers.add(1);
        System.out.println("2");
        numbers.addFirst(2);
        System.out.println("3");
        numbers.offerFirst(3);
        System.out.printf("Head with getFirst: %s. Head with peekFirst %s%n", numbers.getFirst(), numbers.peekFirst());
        System.out.println("Deque: " + numbers);

        System.out.println("Add to the tail of the queue");
        numbers.addLast(4);
        numbers.offerLast(5);
        System.out.println("Deque: " + numbers);

        System.out.println("Remove from both ends");
        numbers.removeFirst();
        numbers.pollFirst();
        numbers.removeLast();
        numbers.pollLast();
        System.out.println("Deque: " + numbers);

        System.out.println("Using peek/offer/poll");

        System.out.println("Offer 11");
        System.out.println(numbers.offer(11));

        System.out.println("Offer 12");
        System.out.println(numbers.offer(12));
        System.out.println("Deque: " + numbers);

        System.out.println("Peek");
        System.out.println(numbers.peek());

        System.out.println("Poll");
        System.out.println(numbers.poll());
        System.out.println("Deque: " + numbers);

        System.out.println("Poll");
        System.out.println(numbers.poll());
        System.out.println("Deque: " + numbers);

        System.out.println("Poll");
        System.out.println(numbers.poll());
        System.out.println("Deque: " + numbers);

    }

    private static void showPriorityQueueNaturalOrdering() {
        System.out.println("Priority Queue - Natural Ordering");
        System.out.println("Alphabetic ordering");
        Queue<String> names = new PriorityQueue<>();
        names.add("V");
        names.add("P");
        names.add("A");

        System.out.println("Iterate through names: ");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.print(names.poll() + " ");
        }

        System.out.println("\nNumeric Ordering");
        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);

        System.out.println("Iterate through numbers: ");
        Iterator<Integer> numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()) {
            System.out.print(numbers.poll() + " ");
        }
    }

    private static void showPriorityQueueDifferentOrdering() {
        Comparator<Book> comparatorTitle = Comparator.comparing(book -> book.getTitle());
        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);
        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        System.out.println("Ordering by title: ");
        Iterator<Book> bookIterator = booksByTitle.iterator();
        while (bookIterator.hasNext()) {
            Book book = booksByTitle.poll();
            System.out.println(book);
        }

        Comparator<Book> comparatorPrice = Comparator.comparing(Book::getPrice);
        Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);
        booksByPrice.add(new Book("Java", 55.0));
        booksByPrice.add(new Book("Python", 23.0));
        booksByPrice.add(new Book("C++", 99.0));

        System.out.println("Ordering by price: ");
        Iterator<Book> bookIterator2 = booksByPrice.iterator();
        while (bookIterator2.hasNext()) {
            Book book = booksByPrice.poll();
            System.out.println(book);
        }
    }
}
