package questions.lvti;

import java.util.ArrayList;

class Q2_3068 {
    public static void main(String[] args) {
        var values = new ArrayList<String>();
        values.add("d");
        values.add("c");
        values.add("x");
        values.add("a");

        values.sort((var a, var b) -> a.compareTo(b));

        values.sort((a, b) -> a.compareTo(b));

        String[] sa = values.toArray(new String[0]);
    }
}
