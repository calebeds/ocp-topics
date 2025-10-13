package questions.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Q2_1738 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int sum = list.stream()
                .mapToInt(i -> i)
                .sum();

        System.out.println("sum: " + sum);

//        int max = list.stream().max(Comparator.comparing(a -> a)).get();
        int max = list.stream().mapToInt(i -> i.intValue()).max().getAsInt();
        System.out.println("max: " + max);

        List<Integer> list2 = Arrays.asList(10, 47, 33, 23);
        int max2 = list2.stream()
                .reduce((a, b) -> Integer.max(a, b))
                .get();

        System.out.println(max2);

        int max3 = list2.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
        System.out.println(max3);
    }
}
