package questions.optionals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class Q2_1793 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 47, 33, 23);

        Function<Integer, Integer> functionLambda = i -> i;
        Function<Integer, Integer> functionMethodRef = Integer::intValue;

        int max = list.stream()
//                .max(Comparator.comparing(i -> i))
//                .max(Comparator.comparing(functionLambda))
                .max(Comparator.comparing(functionMethodRef))
                .get();

        System.out.println(max);

        int max2 = list.stream()
//                .reduce((a, b) -> a > b ? a : b)
                .reduce((a, b) -> Integer.max(a, b))
                .get();

        System.out.println(max2);


        int max3 = list.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
        System.out.println(max3);
    }
}
