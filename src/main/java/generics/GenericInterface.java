package generics;

import java.util.Objects;

interface Moveable<T> {
    void move(T t);
}

class MoveFeline implements Moveable<Cat> {
    public void move(Cat c) {};
}

class MoveCanine implements Moveable<Dog> {

    @Override
    public void move(Dog dog) {

    }
}

class SomeMoveable<U> implements Moveable<U> {
    public void move(U u) {}
}

class GenericInterface {
    public static void main(String[] args) {
        new MoveFeline().move(new Cat());
//        new MoveFeline().move(new Dog());
        new MoveCanine().move(new Dog());
//        new MoveCanine().move(new Cat());

        new SomeMoveable<Dog>().move(new Dog());
        new SomeMoveable<Cat>().move(new Cat());
    }
}

class RawMoveable implements Moveable { // old way
    public void move(Object o) {}
}
