package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceTypes {
    public static void main(String[] args) {
        showBoundMethodReferences();
        showUnboundMethodReferences();
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

}
