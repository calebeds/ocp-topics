package questions.streams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Q2_2024 {
    public static void main(String[] args) {
        DoubleStream doubleStream = DoubleStream.of(0, 0, 4);
        double sum = doubleStream.filter(i -> i % 2 == 0).sum();
        System.out.println(sum);

        OptionalDouble optionalDouble = Stream.of(1.0, 3.0)
                .mapToDouble(n -> n.doubleValue())
                .filter(n -> n % 2 == 0)
                .average();

        optionalDouble.ifPresent(System.out::println);
    }
}
