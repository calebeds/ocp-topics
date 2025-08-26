package privateinterface;

interface Tennis {
    private static void hit(String stroke) {
        System.out.println("Hitting a " + stroke);
    }

    private static void smash() {
        hit("smash");
    }
    default void forehand() {
        hit("forehand");
    }

    default void backhand() {
        smash();
        hit("backhand");
    }
}

class SportTennis implements Tennis {}

class PrivateInterfaceMethods {
    public static void main(String[] args) {
        Tennis tennis = new SportTennis();
        tennis.backhand();
        tennis.forehand();
    }
}
