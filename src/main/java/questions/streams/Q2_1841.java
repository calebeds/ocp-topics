package questions.streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class Q2_1841 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    atomicInteger.incrementAndGet();
                    return n % 2 == 0;
                })
                .forEach(System.out::println);

        System.out.println(atomicInteger);
    }
}
