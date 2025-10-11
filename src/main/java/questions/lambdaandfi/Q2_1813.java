package questions.lambdaandfi;

import java.util.function.DoubleSupplier;

class ABook {
    String title;
    Double price;

    public ABook(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}

class Q2_1813 {
    public static void main(String[] args) {
        ABook book = new ABook("Java in 24 Hrs", null);

        DoubleSupplier doubleSupplierLambda = () -> book.getPrice();
        DoubleSupplier doubleSupplierMR = book::getPrice;

        System.out.println(book.getTitle());

        System.out.println(doubleSupplierMR.getAsDouble());
    }
}
