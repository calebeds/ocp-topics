package javaio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

class AttributesView {
    public static void main(String[] args) throws IOException {
        var path = Path.of("./src/main/java/javaio/Attributes.java");
        System.out.println(path);
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("isDirectory: " + basicFileAttributes.isDirectory());
        System.out.println("isRegularFile: " + basicFileAttributes.isRegularFile());
        System.out.println("isSymbolicLink: " + basicFileAttributes.isSymbolicLink());
        System.out.println("size: " + basicFileAttributes.size());
        System.out.println("lastModifiedTime: " + basicFileAttributes.lastModifiedTime());

        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes2 = basicFileAttributeView.readAttributes();
        final long THIRTY_MINS_MSEC = 1000 * 60 * 30;
        FileTime lastModifiedTime = FileTime.fromMillis(basicFileAttributes2.lastModifiedTime().toMillis() + THIRTY_MINS_MSEC);

        basicFileAttributeView.setTimes(lastModifiedTime, null, null);

        basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("lastModifiedTime: " + basicFileAttributes.lastModifiedTime());
    }
}
