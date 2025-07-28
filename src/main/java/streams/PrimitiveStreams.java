package streams;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
//        useSum();
//        useRanges();
//        mapObjectStreams();
//        mapPrimitiveStreams();
//        showMaxMinAverage();
        showStats(IntStream.empty());
        showStats(IntStream.of(5, 10, 15, 20));
    }

    private static void useSum() {
        Stream<Integer> numbers = Stream.of(1, 2, 3);

        System.out.println("sum: " + numbers.reduce(0, (n1, n2) -> n1 + n2));

        IntStream intStream = Stream.of(1, 2, 3)
                .mapToInt(n -> n);

        int total = intStream.sum();
        System.out.println("sum: " + total);
    }

    private static void useRanges() {
        System.out.println("Range: ");

        IntStream.range(1, 5)
                .forEach(System.out::println);

        System.out.println("Range Closed: ");

        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);
    }

    private static void mapObjectStreams() {
        Stream.of("ash", "beech", "sycamore")
                .map(tree -> tree.toUpperCase())
                .forEach(System.out::println);

        DoubleStream doubleStream = Stream.of("ash", "beech", "sycamore")
                .mapToDouble(tree -> tree.length());
        doubleStream.forEach(System.out::println);

        IntStream intStream = Stream.of("ash", "beech", "sycamore")
                .mapToInt(tree -> tree.length());
        intStream.forEach(System.out::println);

        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                .mapToLong(tree -> tree.length());
        longStream.forEach(System.out::println);
    }

    private static void mapPrimitiveStreams() {
        Stream<String> streamAges = IntStream.of(1, 2, 3)
                .mapToObj(n -> "Number: " + n);

        streamAges.forEach(System.out::println);

        DoubleStream doubleStream = IntStream.of(1, 2, 3)
                .mapToDouble(n -> (double) n);
        doubleStream.forEach(System.out::println);

        IntStream.of(1, 3, 3)
                .map(n -> n * 2)
                .forEach(System.out::println);

        IntStream.of(1, 2, 3)
                .mapToLong(n -> (long) n)
                .forEach(System.out::println);
    }

    private static void showMaxMinAverage() {
        OptionalInt max = IntStream.of(10, 20, 30)
                .max();
        max.ifPresent(System.out::println);

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0)
                .min();

        System.out.println(min.orElseThrow());

        OptionalDouble average = LongStream.of(10L, 20L, 30L)
                .average();
        System.out.println(average.orElseGet(() -> Math.random()));
    }

    private static void showStats(IntStream numbers) {
        IntSummaryStatistics intSummaryStatistics =
                numbers.summaryStatistics();

        int min = intSummaryStatistics.getMin();
        System.out.println("Min: " + min);

        int max = intSummaryStatistics.getMax();
        System.out.println("Max: " + max);

        long count = intSummaryStatistics.getCount();
        System.out.println("Count: " + count);

        long sum = intSummaryStatistics.getSum();
        System.out.println("Sum: " + sum);
    }
}
