package questions.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class Q2_1300 {
    public static void main(String[] args) {
//        Map map = new TreeMap();
//        Map<Object, Object> map = new TreeMap<Object, Object>();
//        Map<Object, ?> map = new LinkedHashMap<>();
//        Map<Object, ? super Object> map = new LinkedHashMap<>();
//        Map<Object, ? super ArrayList> map = new LinkedHashMap<Object, ArrayList>();
        Map map = new LinkedHashMap();

        map.put("1", new ArrayList<>());
        map.put(1, new Object());
        map.put(1.0, "Hello");

        System.out.println(map);
    }
}
