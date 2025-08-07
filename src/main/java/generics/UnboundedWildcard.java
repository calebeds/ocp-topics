package generics;

import java.util.ArrayList;
import java.util.List;

class UnboundedWildcard {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sean");
        showList(names);
    }

//    private static void showList(List<Object> list) {
    private static void showList(List<?> list) {
        for(Object object: list) {
            System.out.println(object);
        }

//        list.add("test"); // <?> imples read-only
    }
}
