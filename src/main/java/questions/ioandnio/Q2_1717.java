package questions.ioandnio;

import java.io.RandomAccessFile;

class Q2_1717 {
    public static void main(String[] args) {
        try {
            var raf = new RandomAccessFile("/tmp/test.txt", "rwd");
//            raf.writeChars("abcdefgihl");
            raf.writeChars("hello");
            raf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
