package collections;

import java.util.Comparator;
import java.util.Objects;

class Product implements Comparable<Product> {
    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.id, o.getId());
    }
}
