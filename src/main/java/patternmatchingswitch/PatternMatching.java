package patternmatchingswitch;

class PatternMatching {
    private static void whatType(Object o) {
        switch (o) {
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognized");
        }
    }

    private static void infoOnType(Object o) {
        switch (o) {
            case String s when s.startsWith("A") -> System.out.println("String beginning with A: " + s);
            case Integer i when i > 10 -> System.out.println("Integer > 10: " + i);
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognized");
        }
    }

    public static void main(String[] args) {
//        whatType("ABC");
//        whatType(122);
//        whatType(null);
//        whatType(32.32);

        infoOnType("ABC");
        infoOnType("abc");
        infoOnType(122);
        infoOnType(null);
        infoOnType(32.32);
    }
}
