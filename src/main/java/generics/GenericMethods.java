package generics;

class GenericMethods {
    public static void main(String[] args) {
        showGenericMethod("CALEBE");
        showGenericMethod(1.1);

        register(new Dog(), "Caleb", 3);
        register(new Dog(), "Caleb", 2);

        MyGeneric<Integer> myGeneric = createGeneric(4);
        System.out.println(myGeneric.getT());
    }

    public static <T> void showGenericMethod(T t) {
        MyGeneric<T> myGeneric = new MyGeneric<>(t);
        System.out.println(myGeneric.getT());
    }

    public static <T, U, V> void register(T t, U u, V v) {
        Register<T, U, V> register = new Register<>(t, u, v);
        System.out.println("Register: " + register.getName() + " : " + register.getAge());
    }

    public static <T> MyGeneric<T> createGeneric(T t) {
        return new MyGeneric<>(t);
    }
}
