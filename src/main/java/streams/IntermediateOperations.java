package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
//        doFilter();
//        doSortedOrder();
//        doSortedFromBook();
//        doSorted2();
//        doMap();
//        doFlatMap();
//        doLimit();
        doDistinct();
    }

    private static void doSortedFromBook() {
        Stream.of("Toby", "Anna", "Leroy", "Alex")
                .peek(name -> System.out.println("0." + name))
                .filter(name -> name.length() == 4)
                .peek(name -> System.out.println("1." + name))
                .sorted()
                .peek(name -> System.out.println("2." + name))
                .limit(2)
                .forEach(name -> System.out.println("3. " + name));
    }

    private static void doSortedOrder() {
        Stream.of("Tim", "Jim", "Peter", "Ann")
                .peek(name -> System.out.println("0." + name))
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.println("1." + name))
                .sorted()
                .peek(name -> System.out.println("2." + name))
                .limit(2)
                .forEach(name -> System.out.println("3." + name));
    }

    private static void doSorted2() {
        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);
        Stream.of(mary, john)
                .sorted(Comparator.comparing(person -> person.getAge()))
                .forEach(System.out::println);
    }

    private static void doFilter() {
        Stream.of("galway", "mayo", "roscommon")
                .filter(countryName -> countryName.length() > 5)
                .forEach(name -> System.out.println("Filtered element: " + name));
    }

    private static void doMap() {
        Stream.of("Book", "Pen", "Ruler")
                .map(name -> name.length())
                .forEach(length -> System.out.println("Length: " + length));
    }

    private static void doFlatMap() {
        List<String> list1 = Arrays.asList("Calebe", "Oliveira");
        List<String> list2 = Arrays.asList("Mary", "Ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::println);
    }

    private static void doLimit() {
        Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99)
                .peek(integer -> System.out.println("A - " + integer))
                .filter(integer -> integer > 40)
                .peek(integer -> System.out.println("B - " + integer))
                .limit(2)
                .forEach(integer -> System.out.println("C - " + integer));
    }

    private static void doDistinct() {
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(bird -> System.out.println("1. " + bird))
                .distinct()
                .forEach(bird -> System.out.println("2. " + bird));
    }

}
