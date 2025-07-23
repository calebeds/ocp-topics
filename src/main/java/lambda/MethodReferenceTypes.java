package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceTypes {
    public static void main(String[] args) {
        showBoundMethodReferences();
        showUnboundMethodReferences();
        showStaticMethodReferences();
        showConstructorMethodReferences();
    }

    private static void showBoundMethodReferences() {
        String name = "Mr. Joe Bloggs";

        Supplier<String> lowerLambda = () -> name.toLowerCase();
        Supplier<String> lowerMethodReference = name::toLowerCase;

        System.out.println("Lambda: " + lowerLambda.get());
        System.out.println("Method Reference: " + lowerMethodReference.get());

        Predicate<String> titleLambda = (title) -> name.startsWith(title);
        Predicate<String> titleMethodReference = name::startsWith;

        System.out.println("Lambda: " + titleLambda.test("Mr."));
        System.out.println("Method Reference: " + titleMethodReference.test("Ms."));
    }

    private static void showUnboundMethodReferences() {
        Function<String, String> upperLambda = s -> s.toUpperCase();
        Function<String, String> upperMethodReference = String::toUpperCase;

        System.out.println("Lambda: " + upperLambda.apply("calebe"));
        System.out.println("Method Reference: " + upperMethodReference.apply("calebe"));

        BiFunction<String, String, String> concatLambda = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMethodReference = String::concat;

        System.out.println("Lambda: " + concatLambda.apply("Calebe ", "Oliveira"));
        System.out.println("Method Reference: " + concatMethodReference.apply("Sean ", "Kennedy"));
    }

    private static void showStaticMethodReferences() {
        Consumer<List<Integer>> sortLambda = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMethodReference = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
        sortLambda.accept(listOfNumbers);
        System.out.println("Sorted lambda: " + listOfNumbers);


        listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
        sortMethodReference.accept(listOfNumbers);
        System.out.println("Sorted method reference: " + listOfNumbers);
    }

    private static void showConstructorMethodReferences() {
        Supplier<StringBuilder> supplierLambda = () -> new StringBuilder();
        Supplier<StringBuilder> supplierMethodReference = StringBuilder::new;

        StringBuilder stringBuilder = supplierLambda.get();
        stringBuilder.append("lambda version");
        System.out.println(stringBuilder);

        StringBuilder stringBuilder2 = supplierMethodReference.get();
        stringBuilder2.append("method reference version");
        System.out.println(stringBuilder2);


        Function<Integer, List<String>> functionLambda = x -> new ArrayList<>(x);
        Function<Integer, List<String>> functionMethodReference = ArrayList::new;
        List<String> list = functionLambda.apply(10);
        list.add("21");
        System.out.println(list);

        List<String> list2 = functionLambda.apply(5);
        list2.add("9");
        System.out.println(list2);
    }

}
