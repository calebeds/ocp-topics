package questions.advancedclassdesign;

import java.util.TreeSet;

enum Size {
    TALL, JUMBO, GRANDE;
}

class CoffeeMug {
    public static void main(String[] args) {
        TreeSet<Size> hs = new TreeSet<>();
        hs.add(Size.GRANDE);
        hs.add(Size.JUMBO);
        hs.add(Size.GRANDE);
        hs.add(Size.TALL);
        hs.add(Size.TALL);
        hs.add(Size.JUMBO);

        for (Size size: hs) {
            System.out.println(size);
        }
    }
}

class Q2_1508 {
}
