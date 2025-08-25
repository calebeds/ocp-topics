package javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

class RelativizeExamples {
    public static void main(String[] args) {
//        showRelativePaths();
        showAbsolutePaths();
//        showMixedPaths();
    }

    private static void showRelativePaths() {
        Path p1 = Paths.get("cattle.txt");
        Path p2 = Paths.get("farm/horses.txt");

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        System.out.println("p1.relativize(p2) " + p1.relativize(p2));
        System.out.println("p2.relativize(p1) " + p2.relativize(p1));
    }

    private static void showAbsolutePaths() {
        Path p1 = Path.of("/cattle.txt");
        Path p2 = Paths.get("/home/farm/horses.txt");

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        System.out.println("p1.relativize(p2) " + p1.relativize(p2));
        System.out.println("p2.relativize(p1) " + p2.relativize(p1));
    }

    private static void showMixedPaths() {
        Path p1 = Paths.get("cattle.txt");
        Path p2 = Paths.get("/cattle.txt");

        System.out.println(p1.relativize(p2));
    }
}
