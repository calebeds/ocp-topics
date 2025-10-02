package questions.collections;

class GenericType<K> {
    K x;

    GenericType(K x) {
        this.x = x;
    }

    K getX() {
        return x;
    }
    void setX() {
        this.x = x;
    }
}

class Fish {
    @Override
    public String toString() {
        return "This is a Fish";
    }
}

class Q2_1110 {
    public static void main(String[] args) {
        GenericType<String> genericType = new GenericType<>("Sean");
        System.out.println(genericType.getX());
        GenericType<Integer> genericType2 = new GenericType<>(Integer.parseInt("4"));
        System.out.println(genericType2.getX() + 4);
        GenericType<Fish> genericType3 = new GenericType<>(new Fish());
        System.out.println(genericType3.getX());
    }
}
