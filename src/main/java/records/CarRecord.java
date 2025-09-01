package records;

record CarRecord(String regNumber, String owner) implements I {
//    private final int age;  //instance fields must be listed in constructor signature above

    static final String currentYear = "25";

    // custom canonical constructor
//    public CarRecord(String regNumber, String owner) {
//        if(regNumber.length() <= 4) {
//            throw new IllegalArgumentException();
//        }
//        this.regNumber = regNumber;
//        this.owner = owner;
//    }

    // custom compact constructor
    public CarRecord {
        if(regNumber.length() <= 4) {
            throw new IllegalArgumentException();
        }
    }


    boolean inNewCar() {
        return regNumber().substring(0,2).equals(currentYear);
    }

    static CarRecord createBlankCarRecord() {
        return new CarRecord("     ", "");
    }

    @Override
    public String owner() {
        return owner.toUpperCase();
    }
}

interface I {}
