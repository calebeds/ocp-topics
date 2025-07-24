package lambda.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Assignment {
    public static void main(String[] args) {
        showConsumer();
        showSupplier();
        showPredicate();
        showFunction();

        List<Person> people = getPeople();
        sortAge(people);
        sortName(people);
        sortAge(people);

    }

    private static void showConsumer() {
        Printable<String> printableLambda = word -> System.out.println(word);

        printableLambda.print("Printable lambda");

        Consumer<String> consumerLambda = word -> System.out.println(word);
        Consumer<String> consumerMethodReference = System.out::println;;

        consumerLambda.accept("Printable consumer lambda");
        consumerMethodReference.accept("Printable consumer method reference");
    }

    private static void showSupplier() {
        Retrievable<Integer> retrievable = () -> 77;
        System.out.println(retrievable.retrieve());

        Supplier<Integer> supplier = () -> 77;
        System.out.println(supplier.get());
    }

    private static void showPredicate() {
        Evaluate<Integer> evaluate = testVar -> testVar < 0;

        System.out.println("Is -1 negative? " + evaluate.isNegative(-1));
        System.out.println("Is -1 negative? " + evaluate.isNegative(+1));

        Predicate<Integer> predicate = testVar -> testVar < 0;

        predicate.test(-1);
        predicate.test(+1);

        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(check(4, isEven));
        System.out.println(check(7, isEven));
    }

    private static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private static void showFunction() {
        Functionable<Integer, String> functionable = (number) -> "Number is " + number;
        System.out.println("Functionable interface: " + functionable.applyThis(25));

        Function<Integer, String> function = (number) -> "Number is " + number;
        System.out.println("Function interface: " + function.apply(25));

    }

    public static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;
    }

    private static void sortAge(List<Person> people) {
        people.sort(Comparator.comparing(p -> p.getAge()));

        System.out.println("After sort by Age");
        people.forEach(person -> System.out.println(person));
    }

    private static void sortName(List<Person> people) {
        people.sort(Comparator.comparing(p -> p.getName()));

        System.out.println("After sort by Name");
        people.forEach(person -> System.out.println(person));
    }

    private static void sortHeight(List<Person> people) {
        people.sort(Comparator.comparing(p -> p.getHeight()));

        System.out.println("After sort by Height");
        people.forEach(person -> System.out.println(person));
    }
}
