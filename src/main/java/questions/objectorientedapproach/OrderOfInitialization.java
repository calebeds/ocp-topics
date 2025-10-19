package questions.objectorientedapproach;

class OrderOfInitialization {
    public static void main(String[] args) {
        new Dishwasher();
    }

    static Table t = new Table();
    static Dishwasher dw = new Dishwasher();
}

class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
}

class Table {
    static Bowl b1 = new Bowl(1);

    Table() {
        System.out.println("Table()\n");
    }

    static Bowl b2 = new Bowl(2);
}

class Dishwasher {
    Bowl b3 = new Bowl(3);
    static Bowl b4 = new Bowl(4);

    public Dishwasher() {
        System.out.println("Dishwasher()\n");
    }

    static Bowl b5 = new Bowl(5);
}