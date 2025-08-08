package equalsandhashcode;

class Bar {
    private int fooValue;

    Bar(int fooValue) {
        this.fooValue = fooValue;
    }

    public int getFooValue() {
        return fooValue;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Foo && ((Foo) object).getFooValue() == this.fooValue;
    }

    @Override
    public int hashCode() {
        return fooValue * 17;
    }

}

class HashCodeTest {
    public static void main(String[] args) {
        Bar f1 = new Bar(2);
        Bar f2 = new Bar(2);
        Bar f3 = new Bar(3);

        System.out.println(f1.hashCode());
        System.out.println(f2.hashCode());
        System.out.println(f3.hashCode());
    }
}
