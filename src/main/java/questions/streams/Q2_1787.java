package questions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Q2_1787 {
    public static void main(String[] args) {
        Stream<List<String>> streamOfLists = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("d", "c"),
                Arrays.asList("a", "c")
        );

        streamOfLists
                .filter(list -> list.contains("c"))
                .flatMap(List::stream)
                .forEach(System.out::println);
    }
}
