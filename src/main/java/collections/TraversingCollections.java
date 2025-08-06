package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

class TraversingCollections {
    public static void main(String[] args) {
        // Adding to a list
//        addListUnsupportedOperationException();
//        addListConcurrentModificationException();
//        addListUsingIterator();
//        addListUsingCopyOnWriteCollection();

        // Removing from a List
//        removeListUsingIterator();
//        removeListUsingRemoveIf();

        // Adding to a set
//        addSetDeferredInsertion();
//        addSetUsingCopyOnWriteCollection();

        // Removing from a Set
//        removeSetUsingIterator();
//        removeSetUsingRemoveIf();

        // Adding to a map
//        addMapDeferredInsertion();
//        addMapUsingConcurrentHashMap();

        // Removing from a map
//        removeMapUsingIterator();
        removeMapUsingStreams();

    }

    private static void addListUnsupportedOperationException() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//        List<String> names = List.of("Alice", "Bob", "Charlie");

        names.add("SK");

        names.set(0, names.get(0).toUpperCase());
        System.out.println(names);
    }

    private static void addListConcurrentModificationException() {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        for(String name: names) {
            if(name.equals("Bob")) {
                names.add("David");
            }
        }
    }

    private static void addListUsingIterator() {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        for(var iterator = names.listIterator(); iterator.hasNext(); ) {
            String name = iterator.next();
            if(name.equals("Bob")) {
                iterator.add("David");
            }
        }

        System.out.println(names);
    }

    private static void addListUsingCopyOnWriteCollection() {
        List<String> names = new CopyOnWriteArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        for(String name: names) {
            if(name.equals("Bob")) {
                names.add("David");
            }
        }

        System.out.println(names);
    }

    private static void removeListUsingIterator() {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Bob"));

        // Iterator has a remove() method.
        for(var iterator = names.iterator(); iterator.hasNext(); ) {
            String name = iterator.next();
            if(name.equals("Bob")) {
                iterator.remove();
            }
        }

        System.out.println(names);
    }

    private static void removeListUsingRemoveIf() {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Bob"));
        names.removeIf(name -> name.equals("Bob"));
        System.out.println(names);
    }

    private static void addSetDeferredInsertion() {
        Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));

        Set<String> toAdd = new HashSet<>();
        for(String element: names) {
            if("Alice".equals(element)) {
                toAdd.add("Emily");
            }
        }

        names.addAll(toAdd);
        System.out.println(names);
    }

    private static void addSetUsingCopyOnWriteCollection() {
        Set<String> names = new CopyOnWriteArraySet<>(Set.of("Bob", "Alice", "Charlie"));

        for(String name: names) {
            if(name.equals("Alice")) {
                names.add("Emily");
            }
        }

        System.out.println(names);
    }

    private static void removeSetUsingIterator() {
        Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));

        for(var iterator = names.iterator(); iterator.hasNext(); ) {
            String name = iterator.next();
            if(name.equals("Charlie")) {
                iterator.remove();
            }
        }

        System.out.println(names);
    }

    private static void removeSetUsingRemoveIf() {
        Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
        names.removeIf(name -> name.equals("Alice"));
        System.out.println(names);
    }

    private static void addMapDeferredInsertion() {
        Map<String, Integer> names = new TreeMap<>();

        names.put("Charlie", 25);
        names.put("Alice", 31);
        names.put("Bob", 21);

        Map<String, Integer> toAdd = new HashMap<>();
        for(Map.Entry<String, Integer> entry: names.entrySet()) {
            if("Alice".equals(entry.getKey())) {
                toAdd.put("Alice", 32);
            }
        }

        names.putAll(toAdd);

        System.out.println(names);
    }

    private static void addMapUsingConcurrentHashMap() {
        Map<String, Integer> names = new ConcurrentHashMap<>();
        names.put("Alice", 31);
        names.put("Bob", 31);
        names.put("Charlie", 31);
        names.put("Andrew", 31);

        for(var entry: names.entrySet()) {
            if(entry.getKey().equals("Alice")) {
                names.put("Emily", 24);
            }
        }

        System.out.println(names);
    }

    private static void removeMapUsingIterator() {
        Map<String, Integer> names = new TreeMap<>();
        names.put("Alice", 31);
        names.put("Bob", 21);
        names.put("Charlie", 39);
        names.put("Andrew", 31);

        Iterator<Map.Entry<String, Integer>> iterator = names.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() < 30) {
                iterator.remove();
            }
        }

        System.out.println(names);
    }

    private static void removeMapUsingStreams() {
        Map<String, Integer> names = new TreeMap<>();
        names.put("Alice", 31);
        names.put("Bob", 21);
        names.put("Charlie", 39);
        names.put("Andrew", 31);

        names = names.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().startsWith("A"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(names);
    }
}
