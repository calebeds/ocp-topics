package questions.objectorientedapproach;

enum Coffee {
    EXPRESSO("Very Strong"), MOCHA("Bold"), LATTE("Mild");
    public String strength;
    Coffee(String strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return String.valueOf(strength);
    }
}

class Q2_3350 {
    public static void main(String[] args) {
        System.out.println(Coffee.EXPRESSO);

        Coffee coffee = Coffee.valueOf("EXPRESSO");
        System.out.println(coffee);

        Coffee[] coffees = Coffee.values();

        for(Coffee coffeeEl: coffees) {
            System.out.println(coffee);
        }
    }
}
