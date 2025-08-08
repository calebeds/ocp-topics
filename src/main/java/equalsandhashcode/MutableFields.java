package equalsandhashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dog dog = (Dog) object;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        int hash = 5;

        // simple algorithm
        hash = 83 * hash + this.name.length();

        return hash;
    }
}

class MutableFields {
    public static void main(String[] args) {
        Dog spot = new Dog("spot");
        Map<Dog, String> dogs = new HashMap<>();

        dogs.put(spot, "Great Dane");
        System.out.printf("spotInMap %d in map? %s %n", spot.hashCode(), dogs.containsKey(spot));

        spot.setName("Rex");

        System.out.printf("spotInMap %d in map? %s %n", spot.hashCode(), dogs.containsKey(spot));
    }
}
