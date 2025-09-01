package patternmatchingswitch;

sealed abstract class Vehicle permits Car, Boat, Train {}
final class Car extends Vehicle {
    String onRoad() {
        return "I can move on the road";
    }
}
final class Boat extends Vehicle {}
final class Train extends Vehicle {}

class PatternMatchingSwitchExpressions {

    private static void showIfStatements(Vehicle vehicle) {
        if(vehicle instanceof Car c) {
            System.out.println("It's a car: " + c.onRoad());
        } else if(vehicle instanceof Boat) {
            System.out.println("It's a Boat");
        } else if(vehicle instanceof Train) {
            System.out.println("It's a train");
        } else {
            throw new IllegalArgumentException("Invalid Type");
        }
    }

    private static void showPatternMatchSwitch(Vehicle vehicle) {
        switch (vehicle) {
            case Car c -> {
                System.out.println("It's a Car");
                System.out.println("It's a Car: " + c.onRoad());
            }
            case Boat b -> System.out.println("It's a Boat");
            case Train t -> System.out.println("It's a Train");
            default -> throw new IllegalArgumentException("Invalid Type");
        }
    }

    public static void main(String[] args) {
        showIfStatements(new Car());
        showIfStatements(new Boat());
        showIfStatements(new Train());

        showPatternMatchSwitch(new Car());
        showPatternMatchSwitch(new Boat());
        showPatternMatchSwitch(new Train());
    }
}
