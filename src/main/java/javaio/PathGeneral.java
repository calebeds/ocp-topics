package javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

class PathGeneral {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        Path p1 = Path.of("lgc/logo.png");
        System.out.println("Relative Path: " + p1);
        Path p2 = Path.of("/lgc/log.png");
        System.out.println("Absolute Path: " + p2);


        p1 = Path.of("lgc", "log.png");
        System.out.println("Relative Path: " + p1);
        p2 = Path.of("/", "lgc", "log.png");
        System.out.println("Absolute Path: " + p2);

        Path p3 = Paths.get("lgc/logo.png");
        Path p4 = Paths.get("/lgc/logo.png");

        p3 = Paths.get("lgc", "logo.png");
        p4 = Paths.get("/", "lgc", "logo.png");
    }
}
