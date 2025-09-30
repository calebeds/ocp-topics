package questions.advancedclassdesign;

enum Pets {
    DOG(1, "D"),
    CAT(2, "C") { // anonymous class
        @Override
        public String getData() {
            return "CAT" + type + name;
        }
    },
    FISH(3, "F");

    int type;
    String name;

    Pets(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getData() {
        return name + type;
    }
}

class Q2_1457 {
    public static void main(String[] args) {
        Pets spot = Pets.DOG;
        System.out.println(spot.getData());

        Pets fluffy = Pets.CAT;
        System.out.println(fluffy.getData());
    }
}
