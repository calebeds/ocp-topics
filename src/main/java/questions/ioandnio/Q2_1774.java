package questions.ioandnio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

class Q2_1774 {
    public static void main(String[] args) throws IOException {
        var rafUTF = new RandomAccessFile("/tmp/testUTF.txt", "rwd");
        rafUTF.writeUTF("hello world");
        rafUTF.close();

        var rafChars =  new RandomAccessFile("/tmp/testChars.txt", "rwd");
        rafChars.writeChars("hello world");
        rafChars.close();

        var dis = new DataInputStream(new FileInputStream("/tmp/testUTF.txt"));
        String value = dis.readUTF();
        System.out.println(value);
        dis.close();
    }
}
