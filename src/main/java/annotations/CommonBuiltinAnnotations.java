package annotations;

interface Moveable {
    void move();
    boolean equals(Object o);
}

class Person implements Moveable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("Moving");
    }

    @Override
    public String toString() {
        return name;
    }
}

class CommonBuiltinAnnotations {
    public static void main(String[] args) {
        Person coliveira = new Person("Calebe Oliveira");
        System.out.println(coliveira);
        coliveira.move();
    }
}
