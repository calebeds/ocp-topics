package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortingProducts {
    public static void main(String[] args) {
        showComparable();
    }

    private static void showComparable() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(99));
        products.add(new Product(9));
        products.add(new Product(19));
        Collections.sort(products);
        System.out.println(products);
    }
}
