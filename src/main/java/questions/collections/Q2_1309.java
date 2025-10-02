package questions.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Q2_1309 {
    public <E extends CharSequence> Collection<E> getWordsStartingWith(Collection<E> input, char ch) {
        Collection<E> returnValue = new ArrayList<E>();
        int length = input.size();
        for(E element: input) {
            if(element.charAt(0) == ch) {
                returnValue.add(element);
            }
        }

        return returnValue;
    }

    public void checkIt() {
        List<String> a = new ArrayList<>();
        a.add("apple");
        a.add("cherry");

        Set<StringBuffer> b = new HashSet<>();
        b.add(new StringBuffer("pie"));
        b.add(new StringBuffer("banana"));

        Collection<String> ac = getWordsStartingWith(a, 'a');
        Collection<StringBuffer> bc = getWordsStartingWith(b, 'b');
    }
}
