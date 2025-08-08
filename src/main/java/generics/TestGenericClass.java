package generics;

class MyGeneric<T> {
    T instance;
    MyGeneric(T instance) {
        this.instance = instance;
    }

    T getT() {
        return instance;
    }
}

class TestGenericClass {
    public static void main(String[] args) {
        MyGeneric<String> generic = new MyGeneric<>("Calebe");
        System.out.println(generic.getT());

        MyGeneric<Integer> generic2 = new MyGeneric<>(1);
        System.out.println(generic2.getT());
    }
}
