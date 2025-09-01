package sealedclasses;

sealed interface Driveable permits Vehicle {

}

sealed class Vehicle implements Driveable permits Car {
}

sealed class Car extends Vehicle permits Ford, Volvo {
}

final class Ford extends Car {}

final class Volvo extends Car {}