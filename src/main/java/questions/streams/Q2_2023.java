package questions.streams;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

class Q2_2023 {
    public static void main(String[] args) {
        IntStream intStream1 = IntStream.range(0, 5);
        intStream1.forEach(System.out::println);
        IntStream intStream2 = IntStream.rangeClosed(0, 5);
        intStream2.forEach(System.out::println);

        OptionalDouble avg = IntStream.range(0, 0).average();
        System.out.println(avg);

        IntStream intStream3 = IntStream.range(0, 5);
        double avg2 = intStream3.average().orElse(0);
        System.out.println(avg2);
    }
}
