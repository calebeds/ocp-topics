package questions.objectorientedapproach;

class Q2_1233 {
    class A {

    }

    static class B {}

    public void useClasses() {
        new Q2_1233().new A();
        new Q2_1233.B();
        new B();

        new A();
        this.new A();
        new Q2_1233.A();
    }

    public static void main(String[] args) {
        new Q2_1233().new A();
        new Q2_1233.B();
        new B();
    }
}
