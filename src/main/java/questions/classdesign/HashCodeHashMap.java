package questions.classdesign;

import java.util.HashMap;
import java.util.Map;

class Book {
    private String title, isbn;

    @Override
    public boolean equals(Object o) {
        return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

class BookStore {
    Map<Book, Integer> map = new HashMap<>();
    int getNumberOfCopies(Book b) {
        return map.get(b);
    }

    public void addBook(Book b, int numberOfCopies) {
        map.put(b, numberOfCopies);
    }
}

class HashCodeHashMap {
    static BookStore bookStore = new BookStore();

    public static void main(String[] args) {
        Book book = new Book();
        book.setIsbn("111");

        bookStore.addBook(book, 10);
        System.out.println(bookStore.getNumberOfCopies(book));

        book = new Book();
        book.setIsbn("111");
        System.out.println(bookStore.getNumberOfCopies(book));
    }
}
