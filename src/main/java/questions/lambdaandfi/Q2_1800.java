package questions.lambdaandfi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public void addMarks(int m) {
        this.marks += m;
    }

    public void debug() {
        System.out.println(name + ":" + marks);
    }
}

class Q2_1800 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("S1", 40),
                new Student("S2", 35),
                new Student("S3", 30)
        );

        Consumer<Student> increaseMarks = student -> student.addMarks(10);
        students.forEach(increaseMarks);
        Consumer<Student> studentDebug = student -> student.debug(); //lambda version
        students.stream().forEach(Student::debug); // method reference version
    }
}
