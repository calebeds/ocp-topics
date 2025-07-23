package lambda;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceTypes {
    public static void main(String[] args) {
        showBoundMethodReferences();
    }

    private static void showBoundMethodReferences() {
        String name = "Mr. Joe Bloggs";

        Supplier<String> lowerLambda = () -> name.toLowerCase();
        Supplier<String> lowerMethodReference = name::toLowerCase;

        System.out.println("Lambda: " + lowerLambda.get());
        System.out.println("Method Reference" + lowerMethodReference.get());

        Predicate<String> titleLambda = (title) -> name.startsWith(title);
        Predicate<String> titleMethodReference = name::startsWith;

        System.out.println("Lambda: " + titleLambda.test("Mr."));
        System.out.println("Method Reference" + titleMethodReference.test("Ms."));
    }
}
