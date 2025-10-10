package questions.lambdaandfi;


import java.util.Arrays;
import java.util.List;

class SomeBook {
    String title;
    String genre;

    public SomeBook(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}

interface Reader {
    default void read(SomeBook book) {
        System.out.println("default read");
    }

    void unread(SomeBook book);
}

class Q2_1863 {
    public static void main(String[] args) {
        List<SomeBook> books = Arrays.asList(
                new SomeBook("Gone with the wind", "Fiction"),
                new SomeBook("Bourne Ultimatum", "Thriller"),
                new SomeBook("The Client", "Thriller")
        );

        Reader reader = book -> {
            System.out.println("Reading book: " + book.getTitle());
        };

        books.forEach(
                book -> reader.read(book)
        );
    }
}
