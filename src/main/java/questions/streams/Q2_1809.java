package questions.streams;

import java.util.Arrays;
import java.util.List;

class Book {
    String title;
    Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

class Q2_1809 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        double averagePrice = books.stream()
                .filter(book -> book.getPrice() > 10)
                .mapToDouble(book -> book.getPrice())
                .average()
                .getAsDouble();

        System.out.println(averagePrice);
    }
}
