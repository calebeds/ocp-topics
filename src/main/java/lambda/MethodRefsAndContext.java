package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class MethodRefsAndContext {
    public static void main(String[] args) {
        // No person being passed in => Supplier
        Supplier<Integer> lambda1 = () -> Person.howMany();
        Supplier<Integer> methodReference1 = Person::howMany;
        System.out.println(lambda1.get());
        System.out.println(methodReference1.get());

        // One person to be passed in => Function
        Function<Person, Integer> lambda2 = person -> Person.howMany(person);
        Function<Person, Integer> methodReference2 = Person::howMany;
        System.out.println(lambda2.apply(new Person()));
        System.out.println(methodReference2.apply(new Person()));

        // Two persons to be passed in => BiFunction
        BiFunction<Person, Person, Integer> lambda3 = (person1, person2) -> Person.howMany(person1, person2);
        BiFunction<Person, Person, Integer> methodReference3 = Person::howMany;
        System.out.println(lambda3.apply(new Person(), new Person()));
        System.out.println(methodReference3.apply(new Person(), new Person()));

    }
}

class Person {
    public static Integer howMany(Person... people) {
        return people.length;
    }
}
