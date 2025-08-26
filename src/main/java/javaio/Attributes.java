package javaio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class Attributes {
    public static void main(String[] args) {
        checkAttributes(Path.of("./src/main/java/javaio/Attributes.java"));
        System.out.println();
        checkAttributes(Path.of("./src/main/java/javaio"));
        System.out.println();
    }

    private static void checkAttributes(Path path) {
        System.out.println(path);
        System.out.println("isDirectory: " + Files.isDirectory(path));
        System.out.println("isRegularFile: " + Files.isRegularFile(path));
        System.out.println("isSymbolicLink: " + Files.isSymbolicLink(path));
        System.out.println("isReadable: " + Files.isReadable(path));
        System.out.println("isWritable: " + Files.isWritable(path));
        System.out.println("isExecutable: " + Files.isExecutable(path));

        try {
            System.out.println("isHidden: " + Files.isHidden(path));
            System.out.println("size: " + Files.size(path));
            System.out.println("getLastModifiedTime: " + Files.getLastModifiedTime(path));

            long millisFromEpoch = Files.getLastModifiedTime(path).toMillis();
            ZonedDateTime zonedDateTime = FileTime.fromMillis(millisFromEpoch).toInstant().atZone(ZoneId.of("Europe/Dublin"));
            System.out.println(zonedDateTime);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
