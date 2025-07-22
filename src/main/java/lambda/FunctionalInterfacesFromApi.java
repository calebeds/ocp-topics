package lambda;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class FunctionalInterfacesFromApi {
    public static void main(String[] args) {
        showPredicate();
        showSupplier();
        showConsumer();
        showFunction();
        showUnaryBinaryOperator();
    }

    private static void showPredicate() {
        Predicate<String> predicate = string -> string.contains("City");
        System.out.println("'Vatican City' contains 'City'? " + predicate.test("Vatican City"));;

        BiPredicate<String, Integer> checkLength = (string, length) -> string.length() == length;
        System.out.println("'Vatican City' has a length of 8 characters? " + checkLength.test("Vatican City", 8));
    }

    private static void showSupplier() {
        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        System.out.println("Supplier StringBuilder: " + supplier.get().append("SK"));

        Supplier<LocalTime> localTimeSupplier = () -> LocalTime.now();
        System.out.println("Supplier time: " + localTimeSupplier.get());

        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println("Supplier Double: " + doubleSupplier.get());
    }

    private static void showConsumer() {
        Consumer<String> print = s -> System.out.println(s);
        print.accept("To be or not be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(print);

        Map<String, String> mapCapitalCities = new HashMap<>();

        BiConsumer<String, String> biConsumer = (key, value) -> mapCapitalCities.put(key, value);
        biConsumer.accept("Dublin", "Ireland");
        biConsumer.accept("Washington D.C", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.printf("%s is the capital of %s%n", key, value);
        mapCapitalCities.forEach(mapPrint);
    }

    private static void showFunction() {
        Function<String, Integer> function = s -> s.length();
        System.out.println("Function: " + function.apply("Moscow"));

        BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFunction.apply("William", "Shakespeare"));

        BiFunction<String, String, String> biFunction2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFunction2.apply("William", " Shakespeare"));
    }

    private static void showUnaryBinaryOperator() {
        UnaryOperator<String> unaryOperator = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOperator.apply("Calebe"));

        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOperator.apply("William", " Shakespeare"));
    }
}
