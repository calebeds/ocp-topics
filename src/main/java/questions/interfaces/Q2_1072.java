package questions.interfaces;

class TestClass implements T1, T2 {

    @Override
    public void m1() {
        System.out.println("m1() " + T1.VALUE + " " + T2.VALUE);
    }

    @Override
    public void defMethod() {
        T1.super.defMethod();
    }

    public static void main(String[] args) {
        new TestClass().m1();
    }
}

interface T1 {
    int VALUE = 1;
    void m1();
    default void defMethod() {}
}

interface T2 {
    int VALUE = 2;
    void m1();
    default void defMethod() {}
}

class Q2_1072 {
}
