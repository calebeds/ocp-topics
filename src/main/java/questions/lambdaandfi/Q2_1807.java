package questions.lambdaandfi;

interface A {
    static void m1() {}
}

interface AA extends A {
    void m2();
}


class Q2_1807 {
    public static void main(String[] args) {
        AA aa = () -> System.out.println("m2");
        aa.m2();
    }
}
