package questions.collections;

import java.util.TreeSet;

class Q2_1471 {
    public static void main(String[] args) {
//        TreeSet<Integer> s = new TreeSet<>();
//        TreeSet<Integer> subs = new TreeSet<>();
//
//        for (int i = 328; i >= 324 ; i--) {
//            s.add(i);
//        }
//
//        subs = (TreeSet<Integer>) s.subSet(326, true, 328, true);
//        subs.add(329);
//        System.out.println(s + " " + subs);

        // working

        TreeSet<Integer> s = new TreeSet<>();
        TreeSet<Integer> subs = new TreeSet<>();

        for (int i = 330; i >= 320 ; i-=2) {
            s.add(i);
        }

        subs = (TreeSet<Integer>) s.subSet(322, true, 328, true);
        subs.add(327);
        System.out.println(s + " " + subs);
    }
}
