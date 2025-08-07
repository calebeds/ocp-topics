package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortingCatsMultipleFields {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Trixy", 5));
        cats.add(new Cat("Bella", 7));
        cats.add(new Cat("Bella", 2));

        Comparator<Cat> comparator = Comparator.comparing(Cat::getName)
                .thenComparing(Cat::getAge);

        Collections.sort(cats, comparator);

        System.out.println(cats);
    }
}
