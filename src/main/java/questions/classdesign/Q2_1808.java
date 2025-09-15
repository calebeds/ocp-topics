package questions.classdesign;

import java.util.Random;

class Book2 {
    private String isbn, title;

    public Book2(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) throws NullPointerException {
        return true;
    }
}

class Q2_1808 {
    public static void main(String[] args) {
        Object b1 = new Book2("1111", "Thinking in Java");
        Object b2 = new Book2("1111", "Java in 24 hours");
        System.out.println(b1.equals(b2));
    }
}
