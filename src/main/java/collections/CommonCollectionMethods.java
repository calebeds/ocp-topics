package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class CommonCollectionMethods {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>(Arrays.asList("Lucy", "April", "Lucy"));

        collection.add("Lucy");
        collection.add("April");
        collection.add("Lucy");

        System.out.println("Print: " + collection);
        System.out.println("Remove Lucy: " + collection.remove("Lucy"));
        System.out.println("Print: " + collection);
        System.out.println("Is empty: " + collection.isEmpty());
        System.out.println("Is John in the collection? " + collection.contains("John"));
        System.out.println("Is Lucy in the collection? " + collection.contains("Lucy"));

        System.out.println("Remove if starts with A");
        System.out.println(collection.removeIf(s -> s.startsWith("A")));
        System.out.println();
        System.out.print("Print: ");
        collection.forEach(name -> System.out.print(" " + name));
        System.out.println();
        System.out.println("Clear");
        collection.clear();
        System.out.println("Print: ");
        collection.forEach(System.out::println);
    }
}
