package equalsandhashcode;

import java.util.HashMap;
import java.util.Map;

class Contact {
    private String name;
    private int age;

    Contact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        // simple
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.name.length();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Contact otherContact) {
            return this.age == otherContact.age && this.name.equals(otherContact.name);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class ContactTest {
    private static Map<Contact, String> map = new HashMap<>();

    public static void main(String[] args) {
        Contact john = new Contact("john", 33);
        Contact peter = new Contact("peter", 34);

        System.out.println("john.hashCode() is " + john.hashCode());
        System.out.println("peter.hashCode() is " + peter.hashCode());

        map.put(john, "Irish");
        map.put(peter, "American");

        System.out.println("Getting value of John: " + map.get(john));
        System.out.println("Getting value of Peter: " + map.get(peter));

        Contact mary = new Contact("mary", 21);
        System.out.println("mary.hashCode() is: " + mary.hashCode());
        map.put(mary, "engineer");
        callOtherScope();
        System.out.println("After callOtherScope(): " + map.get(mary));

        testJane();

        System.out.println("Map: " + map);
    }

    private static void callOtherScope() {
        Contact anotherMary = new Contact("mary", 21);
        System.out.println("anotherMary.hashCode() is " + anotherMary.hashCode());

        System.out.println("In callOtherScope(): " + map.get(anotherMary));

        // change mary from engineer to accountant
        map.put(anotherMary, "accountant");
    }

    private static void testJane() {
        Contact jane = new Contact("jane", 21);
        System.out.println("jane.hashCode() is " + jane.hashCode());
        map.put(jane, "nurse");
        System.out.println("Get jane: " + map.get(jane));
    }
}
