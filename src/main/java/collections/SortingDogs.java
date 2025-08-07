package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortingDogs {
    public static void main(String[] args) {
//        showComparable(new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)});
//        showComparable(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

//        showComparator(new Dog[]{new Dog("Rover", 7), new Dog("Spot", 2)});
        showComparator(Arrays.asList(new Dog("Rover", 7), new Dog("Spot", 2)));
    }

    private static void showComparable(Dog[] dogs) {
        Arrays.sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }

    private static void showComparable(List<Dog> dogs) {
        Collections.sort(dogs);
        System.out.println(dogs);
    }

    private static void showComparator(Dog[] dogs) {
        System.out.println("Ascending order");
        Comparator<Dog> ascendingAgeOrder = Comparator.comparing(dog -> dog.getAge());
        Arrays.sort(dogs, ascendingAgeOrder);
        System.out.println(Arrays.toString(dogs));

        System.out.println("Descending order");
        Comparator<Dog> descendingAgeOrder = Comparator.comparing(Dog::getAge).reversed();
        Arrays.sort(dogs, descendingAgeOrder);
        System.out.println(Arrays.toString(dogs));
    }

    private static void showComparator(List<Dog> dogs) {
        System.out.println("Ascending order");
        Comparator<Dog> ascendingAgeOrder = Comparator.comparing(Dog::getAge);
        Collections.sort(dogs, ascendingAgeOrder);
        System.out.println(dogs);

        System.out.println("Descending order");
        Comparator<Dog> descendingAgeOrder = Comparator.comparing(Dog::getAge).reversed();
        Collections.sort(dogs, descendingAgeOrder);
        System.out.println(dogs);

    }
}
