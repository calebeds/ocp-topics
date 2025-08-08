package equalsandhashcode;

class Foo {
    private int fooValue;

    Foo(int fooValue) {
        this.fooValue = fooValue;
    }

    public int getFooValue() {
        return fooValue;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Foo && ((Foo) object).getFooValue() == this.fooValue;
    }


}

class EqualsTest {
    public static void main(String[] args) {
        Foo f1 = new Foo(2);
        Foo f2 = new Foo(2);
        System.out.println(f1.equals(f2));
        System.out.println(f1.equals("CALEBE")); // no ClassCastException
    }
}
