package questions.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Item {
    Integer id;
    String name;

    Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}

class Q2_1762 {
    public static void main(String[] args) {
        List<Item> list = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")
        );

        list.stream()
                .sorted((a, b) -> a.getId().compareTo(b.getId()))
                .forEach(System.out::print);

        System.out.println();

        list.stream()
                .sorted(Comparator.comparing(a -> a.getName()))
                .map((item) -> item.getName())
                .forEach(System.out::print);

        System.out.println();

        list.stream()
                .map(item -> item.getName())
                .forEach(System.out::print);

        System.out.println();

        list.stream()
                .map(item -> item.getName())
                .sorted()
                .forEach(System.out::print);

    }
}
