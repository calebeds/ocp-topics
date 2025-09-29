package questions.advancedclassdesign;

class A {

}

class TestClass2 {
    class A {
        void m() {}
    }

    class B extends A {

    }

    public static void main(String[] args) {
        new TestClass2().new A() {
            @Override
            void m() {}
        };
    }
}

class Q2_1383 {

}
