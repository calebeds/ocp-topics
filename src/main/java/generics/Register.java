package generics;

class Register<T, U, V> {
    private final T type;
    private final U name;
    private final V age;

    public Register(T type, U name, V age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public T getType() {
        return type;
    }

    public U getName() {
        return name;
    }

    public V getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Register{" +
                "type=" + type +
                ", name=" + name +
                ", age=" + age +
                '}';
    }
}

class AnimalRegister {
    public static void main(String[] args) {
        System.out.println(new Register<>(new Dog(), "Shep", 3));
        System.out.println(new Register<>(new Cat(), "Whiskers", 2));
    }
}