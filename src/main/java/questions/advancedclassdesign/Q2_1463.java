package questions.advancedclassdesign;

class Q2_1463 {
    enum EnumA {
        A, AA, AAA
    }

    enum EnumB {
        B, BB, BBB
    }

    public static void main(String[] args) {
        EnumA a = EnumA.valueOf("A");
        System.out.println(a.name());

        for(EnumA enumA: EnumA.values()) {
            System.out.println(enumA);
        }

        // java 11 it doesn't work
        enum EnumC {
            C
        }
    }
}
