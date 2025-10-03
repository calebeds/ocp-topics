package questions.lambdaandfi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Q2_1784 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(2, 4, 6, 9);

        Predicate<Integer> check = (Integer i) -> {
            System.out.println("Checking");
            return i == 4;
        };

//        Predicate even = (Integer i) -> i % 2 == 0;
        Predicate<Integer> even = (Integer i) -> i % 2 == 0;

        values.stream().filter(check).filter(even).count();
    }
}
