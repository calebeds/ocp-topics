package lambda;

import java.util.function.Predicate;

interface Evaluate<T> {
    boolean isNegative(T t);
}

class TestPredicate {
    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(+1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

        int x = 4;
        System.out.printf("Is %d even? %s%n", x, check(4, n -> n % 2 == 0));
        x = 7;
        System.out.printf("Is %d even? %s%n", x, check(4, n -> n % 2 == 0));

        String name = "Mr. Joe Bloggs";
        System.out.printf("Does %s start with Mr.? %s%n", name, check(name, s -> s.startsWith("Mr.")));
        name = "Ms. Ann Bloggs";
        System.out.printf("Does %s start with Mr.? %s%n", name, check(name, s -> s.startsWith("Mr.")));

    }

    public static <T> Boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
