package streams;

import java.util.Arrays;
import java.util.List;

public class StreamLaziness {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("April", "Ben", "Charlie",
                "David", "Benildus", "Christian");

        names.stream()
                .peek(System.out::println)
                .filter(name -> {
                    System.out.println("First filter: " + name);
                    return name.startsWith("B") || name.startsWith("C");
                })
                .filter(name -> {
                    System.out.println("Second filter: " + name);
                    return name.length() > 3;
                })
                .limit(1)
                .forEach(System.out::println);
    }
}
