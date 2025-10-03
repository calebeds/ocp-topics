package questions.lambdaandfi;

import java.util.Arrays;
import java.util.List;

class Book {
    final String name;
    final double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Q2_1866 {
    public static void main(String[] args) {
        List<List<Book>> books = Arrays.asList(
                Arrays.asList(
                        new Book("Windmills of the Gods", 7.0),
                        new Book("Tell me your dreams", 9.0)
                ),
                Arrays.asList(
                        new Book("There is a hippy on the highway", 5.0),
                        new Book("Easy come easy go", 5.0)
                )
        );

        double d = books.stream()
                .flatMap(booksList -> booksList.stream())
                .mapToDouble(book -> book.getPrice())
                .sum();

        System.out.println(d);
    }
}
