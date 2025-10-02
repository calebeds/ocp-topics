package questions.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PersonToCompare {
    String name;
    String dob;

    public PersonToCompare(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }
}

class Q2_1725 {
    public static void main(String[] args) {
        List<PersonToCompare> persons = new ArrayList<>();
        persons.add(new PersonToCompare("Paul", "01012000"));
        persons.add(new PersonToCompare("Peter", "01012990"));
        persons.add(new PersonToCompare("Patrick", "01012002"));

        Collections.sort(persons, new Comparator<PersonToCompare>() {
            @Override
            public int compare(PersonToCompare o1, PersonToCompare o2) {
                return o1.dob.compareTo(o2.dob);
            }
        });

        for(PersonToCompare personToCompare: persons) {
            System.out.println(personToCompare.name + " " + personToCompare.dob);
        }
    }
}
