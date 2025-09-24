package questions.classdesign;

import java.util.ArrayList;
import java.util.List;

class PlaceHolder<K, V> {
    private final K k;
    private final V v;

    PlaceHolder(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public static <X> PlaceHolder<X, X> getDuplicateHolder(X x) {
        return new PlaceHolder<X, X>(x, x);
    }

    public static <T> void fillListSafely(T... items) {
        List<T> list = new ArrayList<>();

        for(T t: items) {
            list.add(t);
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        PlaceHolder<String, String> placeHolder0 = new PlaceHolder<>("a", "b");
        System.out.println(placeHolder0.getK() + " " + placeHolder0.getV());

        PlaceHolder<String, String> placeHolder1 = PlaceHolder.getDuplicateHolder("b");
        System.out.println(placeHolder1.getK() + " " + placeHolder1.getV());

        PlaceHolder<Integer, Integer> placeHolder2 = PlaceHolder.<Integer>getDuplicateHolder(3);
        System.out.println(placeHolder2.getK() + " " + placeHolder2.getV());

        PlaceHolder.fillListSafely("11", Integer.parseInt("33")); // not safe
//        PlaceHolder.<String>fillListSafely("11", Integer.parseInt("33"));

        List<? extends Object> listObject = new ArrayList<String>();
        List<?> listObject2 = new ArrayList<String>(); // same thing as before

        // wild card is always always used in reference declarations
        PlaceHolder<?, ?> placeHolder5 = new PlaceHolder<>(10, 10);
        PlaceHolder<?, ?> placeHolder6 = new PlaceHolder<>(10, "abc");
    }
}

class Q2_1825 {

}
