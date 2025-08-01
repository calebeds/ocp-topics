package collections;

import java.util.Map;
import java.util.TreeMap;

class UseMaps {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(); // sorted by keys
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);

        System.out.println("Contains Key John? " + map.containsKey("John"));
        System.out.println("Contains Value 18? " + map.containsValue(18));
        System.out.println("Is it empty? " + map.isEmpty());
        System.out.println("Get value stored on John: " + map.get("John"));

        System.out.println("Keys:");
        for (String name : map.keySet()) {
            System.out.print(" " + name);
        }

        System.out.println("\nValues:");
        for (Integer age : map.values()) {
            System.out.print(" " + age);
        }

        System.out.println("\nContains Paul? " + map.containsKey("Paul"));
        System.out.println("Contains 21? " + map.containsValue(21));
        System.out.println("Size: " + map.size());
        System.out.println("Clear map.");
        map.clear();
        System.out.println("Size: " + map.size());

        System.out.println("Putting values back in the map");
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);

        map.forEach((key, value) -> System.out.println(key + " maps to " + value));

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        });

//        Set<String> keys = map.keySet();

        map.put("Mike", null);
        map.putIfAbsent("Chris", 99);
        System.out.println(map);
        map.putIfAbsent("Mike", 55);
        System.out.println(map);
        map.putIfAbsent("Luke", 31);
        System.out.println(map);

        Integer original = map.replace("Chris", 81);
        System.out.println(map);
        System.out.println("Original value from Chris: " + original);

        System.out.println("Replace All: ");
        map.replaceAll((name, age) -> name.length());
        System.out.println(map);

        System.out.println("Remove Mike");
        map.remove("Mike");
        System.out.println(map);
    }
}
