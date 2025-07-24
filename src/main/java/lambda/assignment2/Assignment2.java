package lambda.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Assignment2 {
    public static void main(String[] args) {
        sortWithMethodReference();
        showBoundMethodReference();
        showUnboundMethodReference();
        showConstructorMethodReference();
    }

    private static void sortWithMethodReference() {
        List<Integer> list = Arrays.asList(1, 2, 7, 4, 5);

        Consumer<List<Integer>> sortList = (integerList) -> Collections.sort(integerList);

        System.out.println("List before: " + list);
        sortList.accept(list);
        System.out.println("List After: " + list);

        System.out.println("Reinitializing the list");
        list = Arrays.asList(1, 2, 7, 4, 5);

        Consumer<List<Integer>> sortListMethodReference = Collections::sort;

        System.out.println("List before: " + list);
        sortListMethodReference.accept(list);
        System.out.println("List After: " + list);
    }

    private static void showBoundMethodReference() {
        String name = "Mr. Joe Bloggs";
//        Predicate<String> checkPrefix = string -> name.startsWith(string);
        Predicate<String> checkPrefix = name::startsWith;

        System.out.printf("Check if %s has prefix %s: %s%n", name, "Mr.", checkPrefix.test("Mr."));
        System.out.printf("Check if %s has prefix %s: %s%n", name, "Ms.", checkPrefix.test("Ms."));
    }

    private static void showUnboundMethodReference() {
        System.out.println("Unbound method reference");

//        Predicate<String> checkStringEmpty = string -> string.isEmpty();
        Predicate<String> checkStringEmpty = String::isEmpty;

        System.out.println("Check string empty: " + checkStringEmpty.test(""));
        System.out.println("Check string empty: " + checkStringEmpty.test("xyz"));

//        BiPredicate<String, String> startsWith = (param1, param2) -> param1.startsWith(param2);
        BiPredicate<String, String> startsWith = String::startsWith;

        System.out.println("Check starts with: " + startsWith.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("Check starts with: " + startsWith.test("Ms. Joe Bloggs", "Mr."));
    }

    private static void showConstructorMethodReference() {
        System.out.println("Constructor method reference");


//        Supplier<List<String>> createArrayList = () -> new ArrayList<>();
        Supplier<List<String>> createArrayList = ArrayList::new;

        var list = createArrayList.get();
        list.add("Lambda");

        System.out.println("Show List: " + list);

//        Function<Integer, List<String>> createArrayListWithCapacity = capacity -> new ArrayList<>(capacity);
        Function<Integer, List<String>> createArrayListWithCapacity = ArrayList::new;
        list = createArrayListWithCapacity.apply(10);
        list.add("Lambda");

        System.out.println("Show List " + list);
    }
}
