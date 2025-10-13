package questions.lambdaandfi;

import java.util.function.Function;

class Q2_3319 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcdef");

        Function<Character, String> function = c -> "" + Character.valueOf((char) (c + 1));

        for (int i = 0; i < stringBuilder.length(); i++) {
            stringBuilder.replace(i, i + 1, function.apply(stringBuilder.charAt(i)));
        }

        System.out.println(stringBuilder);
    }
}
