package questions.classdesign;

interface Classic {
    int version = 1;
    void read();
}

class MediaReader implements Classic {
    int version = 2;

    @Override
    public void read() {
        System.out.println(Classic.version);
        System.out.println(((Classic) this).version);
    }
}



class Q2_1722 {
    public static void main(String[] args) {
        MediaReader mr = new MediaReader();
        mr.read();
    }
}
