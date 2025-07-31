package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UseSets {
    public static void main(String[] args) {
//        showFactoryMethods();
//        showTreeSet();
        showHashSet();
        showLinkedHashSet();
    }

    private static void showFactoryMethods() {
        Set<String> ofFactoryMethod = Set.of("a", "b", "c");
        Set<String> copyFactoryMethod = Set.copyOf(ofFactoryMethod);

        // UnsupportedOperationException
        ofFactoryMethod.add("d");
        copyFactoryMethod.add("d");
        ofFactoryMethod.add("e");
    }

    private static void showTreeSet() {
        Set<String> names = new TreeSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Anne");

        System.out.println(names);

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(23);
        numbers.add(Integer.valueOf("21"));
        numbers.add(Integer.valueOf("11"));
        numbers.add(99);

        System.out.println(numbers);
    }

    private static void showHashSet() {
        Set<Contact> contactsHS = new HashSet<>();
        contactsHS.add(new Contact("zoe", 45));
        contactsHS.add(new Contact("zoe", 45));
        contactsHS.add(new Contact("alice", 34));
        contactsHS.add(new Contact("andrew", 35));
        contactsHS.add(new Contact("brian", 36));
        contactsHS.add(new Contact("carol", 37));

        System.out.println(contactsHS);
    }

    private static void showLinkedHashSet() {
        Set<Contact> contactsLHS = new LinkedHashSet<>();
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("alice", 34));
        contactsLHS.add(new Contact("andrew", 35));
        contactsLHS.add(new Contact("brian", 36));
        contactsLHS.add(new Contact("carol", 37));

        System.out.println(contactsLHS);
    }

}
