package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PolymorphicIssueWIthGenerics {
    public static void main(String[] args) {
        // The issue
        List<Double> doubles = new ArrayList<>();
        doubles.add(12.3);
//        List<Object> objects = doubles; // COMPILER ERROR

        // A different variation
        List<String> names = new ArrayList<>();
        names.add("Sean");
//        showList(names);
    }

    private static void showList(List<Object> list) {
        for(Object object: list) {
            System.out.println(object);
        }
    }
}
