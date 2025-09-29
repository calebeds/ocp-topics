package questions.advancedclassdesign;

class TestClass implements T1, T2 {

    @Override
    public void m1() {

    }
}

interface T1 {
    int VALUE = 1;
    void m1();
}

interface T2 {
    int VALUE = 2;
    void m1();
}

class Q2_1771 {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println(((T1) testClass).VALUE);
        System.out.println(((T2) testClass).VALUE);
        testClass.m1();
    }
}
