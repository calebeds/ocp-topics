package records;

class CarMain {
    public static void main(String[] args) {
//        Car car = new Car("25154", "Joe Bloggs");
//        System.out.println(car);
//        System.out.println(car.getOwner());
//        System.out.println(car.getRegNumber());


        CarRecord carRecord = new CarRecord("25154", "Joe Bloggs");
        System.out.println(carRecord);
        System.out.println(carRecord.owner());
        System.out.println(carRecord.regNumber());

        System.out.println("Is new car? " + carRecord.inNewCar() );

        System.out.println("Current Year: " + CarRecord.currentYear);

        CarRecord blankCar = CarRecord.createBlankCarRecord();
        System.out.println("Blank onwer: " + blankCar.owner());
        System.out.println("Blank regNumber: " + blankCar.regNumber());
    }
}
