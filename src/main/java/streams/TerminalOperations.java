package streams;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {
//        doCollect();
//        doReduce1();
//        doReduce2();
//        doReduce3();
//        doForEach();
//        doFindAnyFindFirst();
//        doCount();
        doMinAndMax();
    }

    private static void doCollect() {
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(),
                        (stringBuilder, string) -> stringBuilder.append(string),
                        ((stringBuilder1, stringBuilder2) -> stringBuilder1.append(stringBuilder2)));

        System.out.println(word);
    }

    private static void doReduce1() {
        String name = Stream.of("c", "a", "l", "e", "b", "e")
                .reduce("", (string1, string2) -> string1 + string2);
        System.out.println(name);

        Integer product = Stream.of(2, 3, 4)
                .reduce(1, (a, b) -> a * b);
        System.out.println(product);

    }

    private static void doReduce2() {
        BinaryOperator<Integer> operator = (a, b) -> a + b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(6);
        Stream<Integer> multipleElements = Stream.of(3, 4, 5);
        empty.reduce(operator).ifPresent(System.out::println);
        oneElement.reduce(operator).ifPresent(System.out::println);
        multipleElements.reduce(operator).ifPresent(System.out::println);

        Integer val = Stream.of(1, 1, 1)
//                .filter(n -> n > 5)
                .reduce(1, (a, b) -> a);
        System.out.println(val);
    }

    private static void doReduce3() {
        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        int length = stream.reduce(0,
                (n, str) -> n + str.length(),
                (n1, n2) -> n1 + n2);
        System.out.println(length);
    }

    private static void doForEach() {
        Stream<String> names = Stream.of("Cathy", "Pauline", "Zoe");
        names.forEach(name -> System.out.println("name -> " + name));
    }

    private static void doFindAnyFindFirst() {
        Optional<String> any = Stream.of("John", "Paul")
                .findAny();

        any.ifPresent(System.out::println);

        Optional<String> first = Stream.of("John", "Paul")
                .findFirst();
        first.ifPresent(System.out::println);

    }

    private static void doCount() {
        long count = Stream.of("Dog", "Cat")
                .count();
        System.out.println("Count: " + count);
    }

    private static void doMinAndMax() {
        Optional<String> min = Stream.of("deer", "horse", "pig")
                .min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        Optional<Integer> max = Stream.of(4, 6, 2, 12, 9)
                .max((i1, i2) -> i1 - i2);
        max.ifPresent(System.out::println);
    }
}
