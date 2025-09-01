package records;

import java.util.Objects;

class Car {
    private final String regNumber;
    private final String owner;

    public Car(String regNumber, String owner) {
        this.regNumber = regNumber;
        this.owner = owner;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(regNumber, car.regNumber) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, owner);
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
