package lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

class LambdaEffectivelyFinal {
    String name = "";

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("John");

        int x = 12; // final or effectively final

        LambdaEffectivelyFinal instance = new LambdaEffectivelyFinal();

        // Lambdas take a snapshot/picture of local variables; these local
        // variables MUST NOT change. Only setting up lambda here.
        Predicate<String> lambda = s -> {
//            x++;
            instance.name = "Kennedy"; // instance/class vars are okay
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };

        filterData(arrayList, lambda);

        System.out.println(arrayList);

        instance.name = "Sean";
//        x++;

        filterData(arrayList, lambda);
    }

    private static void filterData(ArrayList<String> list, Predicate<String> lambda) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if(lambda.test(iterator.next())) {
                iterator.remove();
            }
        }
    }
}
