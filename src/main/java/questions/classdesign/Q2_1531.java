package questions.classdesign;

class Base {
    int getStatusCode(Object obj) throws NullPointerException {
        return 1;
    }

    Object covr() {
        return null;
    }
}

class Sub extends Base {
    int getStatusCode(String s) { // overload
        return 1;
    }

    @Override
    int getStatusCode(Object obj) throws ClassCastException {
        return 2;
    }

    @Override
    String covr() {
        return "Calebe";
    }

}


class Q2_1531 {
    public static void main(String[] args) {
        Base base = new Sub();
        System.out.println(base.getStatusCode(new Object()));
    }
}
