package streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class ParallelStreams {
    public static void main(String[] args) {
        showSequentialAddition();
        showParallelAddition();
    }

    private static void showSequentialAddition() {
        System.out.println("Sequential Addition");

        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .mapToInt(n -> n.intValue())
                .sum();

        System.out.println("Sum = " + sum);
    }

    private static void showParallelAddition() {
//        Stream<String> animalsStream = List.of("sheep", "pigs", "horses")
//                .parallelStream();

        System.out.println("Parallel Addition");

        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .mapToInt(n -> n.intValue())
                .sum();
        System.out.println("Sum = " + sum);
    }
}
