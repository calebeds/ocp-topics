package questions.advancedclassdesign;

class Outer {
    private int op = 3;


    class Inner {
        private int ip = 5;

        void innerM() {
            System.out.println("Outer private data == " + op);
            System.out.println("Outer private data == " + Outer.this.op);
        }
    }

    void outerM() {
        System.out.println("Inner private data == " + new Inner().ip);
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerM();

        new Outer().outerM();
    }
}

class Q2_1394 {

}
