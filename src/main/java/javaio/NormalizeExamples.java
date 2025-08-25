package javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

class NormalizeExamples {
    public static void main(String[] args) {
        Path p1 = Path.of("./x/y/../sean.txt");
        System.out.println("p1: " + p1);
        System.out.println("p1.normalize(): " + p1.normalize());

        Path p2 = Path.of("/x/y/../z");
        System.out.println("p2: " + p2);
        System.out.println("p2.normalize(): " + p2.normalize());

        Path p3 = Path.of(".\\a");
        System.out.println("p3: " + p3);
        System.out.println("p3.normalize(): " + p3.normalize());

        Path p4 = Paths.get("/a/b/../../x.y");
        Path p5 = Paths.get("/x.y");
        System.out.println("p4: " + p4);
        System.out.println("p5: " + p5);
        System.out.println("p4.normalize(): " + p4.normalize());
        System.out.println("p5.normalize(): " + p5.normalize());
        System.out.println("p4.equals(p5): " + p4.equals(p5));
        System.out.println("p4.normalize().equals(p5.normalize()): " + p4.normalize().equals(p5.normalize()));

    }
}
