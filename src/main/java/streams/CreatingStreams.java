package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class CreatingStreams {
    public static void main(String[] args) {
        createStreamsFromArray();
        createStreamsFromCollection();
        createPrimitiveStreams();
    }

    private static void createStreamsFromArray() {
        Double[] numbers = {1.1, 2.2, 3.3};

        Stream<Double> stream1 = Arrays.stream(numbers);

        long count = stream1.count();
        System.out.println("Number of elements: " + count);

        Stream<Double> stream2 = Stream.of(numbers);
        System.out.println("Number of Elements: " + stream2.count());

        Stream<String> stream3 = Stream.of("Austria", "New Zealand");
        System.out.println("Number of elements: " + stream3.count());
    }

    private static void createStreamsFromCollection() {
        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        Stream<String> animalStream = animalList.stream();
        System.out.println("Number of elements of animal stream: " + animalStream.count());

        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);
        namesToAges.put("Mary", 24);
        namesToAges.put("Alice", 31);
        System.out.println("Number of entries of names to ages: " + namesToAges.entrySet().stream().count());
    }

    private static void createPrimitiveStreams() {
        int[] intArray = {1, 2, 3};
        double[] doubleArray = {1.1, 2.2, 3.3};
        long[] longArray = {1L, 2L, 3L};

        IntStream intStream1 = Arrays.stream(intArray);
        DoubleStream doubleStream1 = Arrays.stream(doubleArray);
        LongStream longStream1 = Arrays.stream(longArray);

        System.out.printf("Count of integerStream = %s, doubleStream = %s, longStream = %s %n", intStream1, doubleStream1, longStream1);
    }

}
