package questions.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Boo implements Serializable {
    transient int t1 = 10;
    static int si = 20;
    int x = 4;
}

class TestClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Boo boo = new Boo();
        boo.si++;
        boo.x++;
        System.out.println(boo.t1 + " " + boo.si + " " + boo.x);
        FileOutputStream fileOutputStream = new FileOutputStream("/tmp/boo.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(boo);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("/tmp/boo.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        boo = (Boo) objectInputStream.readObject();
        objectOutputStream.close();

        System.out.println(boo.t1 + " " + boo.si + " " + boo.x);
    }
}

class Q2_1701 {
}
