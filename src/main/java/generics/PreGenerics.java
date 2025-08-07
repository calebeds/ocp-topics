package generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class PreGenerics {
    public static void main(String[] args) {
        List myList = new ArrayList();
        myList.add("Fred");
        myList.add(43);
        myList.add(BigDecimal.ONE);

        String string = (String) myList.get(0);

//        String string2 = (String) myList.get(1);//class cast exception at runtime

        List<String> myList2 = new ArrayList<>();
        myList2.add("Fred");
//        myList2.add(33);

        String fred = myList2.get(0); // no cast needed
    }
}
