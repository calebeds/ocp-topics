package questions.arrays;

import java.util.Arrays;

class Q2_3102 {
    public static void compare() {
        int[] a = {'h', 'e', 'l'};
        int[] b = {'h', 'e', 'l', 'l', 'o'};

        System.out.println(Arrays.compare(a, b));
        System.out.println(Arrays.compare(b, a));

        int[] c = {'h', 'e', 'k'};
        int[] d = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.compare(c, d));

        int[] e = {'h', 'e', 'm'};
        int[] f = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.compare(e, f));

        int[] g = {'h', 'e', 'm'};
        int[] h = {'h', 'e', 'm'};
        System.out.println(Arrays.compare(g, h));
    }

    public static void mismatch() {
        int[] a = {'h', 'e', 'l'};
        int[] b = {'h', 'e', 'l', 'l', 'o'};

        System.out.println(Arrays.mismatch(a, b));
        System.out.println(Arrays.mismatch(b, a));

        int[] c = {'h', 'e', 'l'};
        int[] d = {'h', 'e', 'l'};
        System.out.println(Arrays.mismatch(c, d));

        int[] e = {'h', 'e', 'm'};
        int[] f = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.mismatch(e, f));
    }

    public static void main(String[] args) {
        compare();
        mismatch();
    }
}
