package questions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Q2_1846 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        );

        Map<String, Double> bookMap =
                books.stream().collect(Collectors.toMap(b -> b.getTitle(), b -> b.getPrice()));

        BiConsumer<String, Double> printPrice = (a, b) -> {
            if(a.startsWith("A")) {
                System.out.println(b);
            }
        };

        bookMap.forEach(printPrice);

        Set<Map.Entry<String, Double>> bookSet = bookMap.entrySet();
        Consumer<Map.Entry<String, Double>> printSet = (entry) -> {
            if(entry.getKey().startsWith("A")) {
                System.out.println(entry.getValue());
            }
        };

        bookSet.forEach(printSet);
    }
}
