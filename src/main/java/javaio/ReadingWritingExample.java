package javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class ReadingWritingExample {
    public static void main(String[] args) {
//        copyTextFile(false);
//        copyTextFile(true);
        copyBinaryFile(false);
//        copyBinaryFile(true);
    }

    private static void copyTextFile(boolean buffering) {
        File src = new File("/home/calebesantos/dev/projects/ocp-prep/src/main/java/javaio/ReadingWritingExample.java");
        File dest = new File("/home/calebesantos/dev/projects/ocp-prep/src/main/java/javaio/ReadingWritingExample2.java");

        try(var bufferedReader = new BufferedReader(new FileReader(src));
                var bufferedWriter = new BufferedWriter(new FileWriter(dest))) {
            if(buffering) {
                String string = null;

                while ((string = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                }
            } else {
                int b;
                while ((b = bufferedReader.read()) != -1) {
                    bufferedWriter.write(b);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyBinaryFile(boolean buffering) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File src = new File("./target/classes/javaio/ReadingWritingExample.class");
        File dest = new File("./target/classes/javaio/ReadingWritingExample2.class");

        try(var in = new BufferedInputStream(new FileInputStream(src));
            var out = new BufferedOutputStream(new FileOutputStream(dest))) {
            if(buffering) {
                var buffer = new byte[1024];
                int numberOfBytesToRead = 0;
                while ((numberOfBytesToRead = in.read(buffer)) > 0) {
                    out.write(buffer, 0, numberOfBytesToRead);
                    out.flush();
                }
            } else {
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
