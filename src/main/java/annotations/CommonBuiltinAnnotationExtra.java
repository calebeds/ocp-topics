package annotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Book {
    @Deprecated(since = "2.0", forRemoval = true)
    public static void print() {}
    public static void readOnline() {}
    public static Integer preview(List<String> pages) {
        return pages.size();
    }
}

class CommonBuiltinAnnotationExtra {
    public static void main(String[] args) {

    }

    @SuppressWarnings("deprecation")
    public static void testDeprecated() {
//        Book.print();
    }

    @SuppressWarnings("unechecked")
    public static void testUnchecked() {
//        Book.preview(new ArrayList<>());
        Book.preview(new ArrayList());
    }

    @SafeVarargs
    public static int abuseVarags(int... array) {
        System.out.println(array.length);

        return array.length;
    }

    @SafeVarargs
    public static int abuseVarags2(List<String>... array) {
        System.out.println(array.length);

        return array.length;
    }

    @SafeVarargs
    public static <T> void printElements(T... elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    @SafeVarargs
    public static void printNumbers(Integer... numbers) {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }



}
