package javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

class PathOperations {
    public static void main(String[] args) {
        getPathInfo(Paths.get("/users/me/documents/projects/thisproject/pom.xml"));
    }

    private static void getPathInfo(Path path) {
        System.out.println("toString: " + path);
        System.out.println("getNameCount: " + path.getNameCount());
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("getName(" + i + "): " + path.getName(i));
        }
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getRoot: " + path.getRoot());

        System.out.println("subpath(0,3): " + path.subpath(0, 3));
        System.out.println("subpath(1,4): " + path.subpath(1, 4));
        System.out.println("subpath(2,3): " + path.subpath(2, 3));

        System.out.println("isAbsolute: " + path.isAbsolute());
    }
}
