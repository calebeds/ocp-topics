package questions.advancedclassdesign;

class OuterWorld {
    public InnerPeace i = new InnerPeace();

    private class InnerPeace {
        private String reason = "none";
    }

    public static void main(String[] args) {
        OuterWorld outerWorld = new OuterWorld();
        String reason = outerWorld.new InnerPeace().reason;
        System.out.println(reason);
    }

    void outerMethod() {
        System.out.println("Inner private data: " + new InnerPeace().reason);
    }
}

class Q2_1580 {
    public static void main(String[] args) {
        OuterWorld outerWorld = new OuterWorld();
//        String reason = outerWorld.new InnerPeace().reason; // can't be accessed here
//        System.out.println(reason);
    }
}
