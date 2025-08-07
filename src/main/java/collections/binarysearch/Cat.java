package collections.binarysearch;

import java.util.Objects;

class Cat implements Comparable<Cat> {
    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object object) { // consistent with compareTo
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cat cat = (Cat) object;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int compareTo(Cat otherCat) {
        return name.compareTo(otherCat.getName());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
