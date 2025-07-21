package lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

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

    }

    private static void showConsumer() {

    }

    private static void showFunction() {

    }

    private static void showUnaryBinaryOperator() {

    }
}
