package lambda;

import java.time.LocalTime;
import java.util.Locale;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FIFromApi {
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

    }

    private static void showFunction() {

    }

    private static void showUnaryBinaryOperator() {

    }
}
