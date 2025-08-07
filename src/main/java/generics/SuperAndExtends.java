package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Animal{}
class Dog extends Animal {}
class Terrier extends Dog {}
class Cat extends Animal {}
class Manx extends Cat {}

class SuperAndExtends {
    public static void main(String[] args) {
        Dog[] dogs0 = {new Dog(), new Dog()};
//        addAnimal(dogs0);

        // polymorphism ok for the base type; List -> ArrayList
        List<Cat> cats1 = new ArrayList<>();

        // polymorphism not ok for the generic type; Animal -> Cat
//        List<Animal> animals = new ArrayList<Cat>();

//        addAnimal(cats1);

        // extends - polymorphic assignments
        // extends is read-only
        List<? extends Animal> animals1 = new ArrayList<Animal>();
//        animals1.add(new Animal());
        List<? extends Animal> animals2 = new ArrayList<Dog>();
        List<? extends Animal> animals3 = new ArrayList<Terrier>();
        List<? extends Animal> animals4 = new ArrayList<Manx>();
//        List<? extends Animal> animals5 = new ArrayList<Object>();

        // super - polymorphic assignments
        List<? super Dog> dogs1 = new ArrayList<Dog>();
        dogs1.add(new Dog());
        List<? super Dog> dogs2 = new ArrayList<Animal>();
        List<? super Dog> dogs3 = new ArrayList<Object>();
//        List<? super Dog> dogs4 = new ArrayList<Terrier>();



        // Declarations for 'extends' and 'super' examples
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        List<Manx> manxCats = new ArrayList<>();
        manxCats.add(new Manx());

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<Terrier> terriers = new ArrayList<>();
        terriers.add(new Terrier());

        // Extends
//        showExtends(objects); // not ok
        showExtends(animals); // ok
        showExtends(cats);
        showExtends(manxCats);
        showExtends(dogs);
        showExtends(terriers);


        // Super
        showSuper(cats);
        showSuper(animals);
        showSuper(objects);
//        showSuper(manxCats);
//        showSuper(dogs);
//        showSuper(terriers);
    }

    private static void addAnimal(Animal[] animals) {
        animals[0] = new Dog();
        animals[1] = new Cat();
    }

    private static void addAnimal(List<Animal> animals) {
        animals.add(new Dog());
    }

    private static void showExtends(List<? extends Animal> list) {
//        list.add(new Cat());//compiler error if we try to modify the list
//        list.add(new Dog());//compiler error if we try to modify the list
//        list.add(new Animal());//compiler error if we try to modify the list

//        for(Dog dog: list) { // compiler error reading - 'list' could be a list of Cats
//
//        }

        // No compiler errors reading once we treat them as Animal; whether this method receives
        // in a list of Animal, Cat, Manx, Dog, or Terrier; they are *all* Animal.
        for(Animal animal: list) {
            System.out.println(animal);
        }
    }

    private static void showSuper(List<? super Cat> list) {
        list.add(new Cat()); // Cat is-a Cat
        list.add(new Manx()); // Manx is-a Cat

//        list.add(new Dog()); // Dog is not a Cat
//        list.add(new Animal()); // Animal is not a Cat
//        list.add(new Object());

//        for(Cat cat: list) { // compiler error when reading - list passed in could be animal
//
//        }

//        for(Animal animal: list) {  // compiler error when reading - list passed in could be object

//        }

        for(Object object: list) {
            System.out.println(object);
        }
    }

}
