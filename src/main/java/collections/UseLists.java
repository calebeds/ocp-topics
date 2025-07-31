package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class UseLists {
    public static void main(String[] args) {
//        showFactoryMethods();
//        showArrayLists();
//        showStack();
        showLinkedList();
    }

    private static void showFactoryMethods() {
        String[] array = new String[] {"Alpha", "Beta", "Charlie"};
        List<String> asListFactoryMethod = Arrays.asList(array);
        List<String> ofFactoryMethod = List.of(array);
        List<String> copyFactoryMethod =  List.copyOf(asListFactoryMethod);

        array[0] = "Delta";
        System.out.println(Arrays.toString(array));
        System.out.println(asListFactoryMethod);

        asListFactoryMethod.set(1, "Echo");
        System.out.println(Arrays.toString(array));
        System.out.println(asListFactoryMethod);

        // UnsupportedOperationException
//        ofFactoryMethod.add("Foxtrot");
//        copyFactoryMethod.add("Forxtrot");
//        asListFactoryMethod.add("Forxtrot");
    }

    private static void showArrayLists() {
        List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("Alan");
        list.add(1, "Sean");
        list.add("Mary");
        list.add("Mary");
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println("Remove first: " + list.remove(0));
        System.out.println("Remove Mary: " +  list.remove("Mary"));
        System.out.println(list);
        System.out.println("Change first to Jack");
        list.set(0, "Jack");
        System.out.println(list);
        System.out.println("Add last name Kennedy");
        list.replaceAll(name -> name + " Kennedy");
        System.out.println(list);
    }

    private static void showStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack);

        System.out.println("Top of the stack: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.push("Helen");
        System.out.println(stack);

    }

    private static void showLinkedList() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Colin");
        names.add("David");
        names.addFirst("Brian");
        names.addFirst("Edward");
        System.out.println(names);

        System.out.println("Remove David.");
        names.remove("David");
        System.out.println(names);

        System.out.println("Remove First.");
        names.removeFirst();
        System.out.println(names);

        System.out.println("Remove Last.");
        names.removeLast();
        System.out.println(names);

    }
}
