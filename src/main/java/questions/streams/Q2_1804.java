package questions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    enum Grade {
        A, B, C, D, F
    }

    private String name;
    private Grade grade;

    public Student(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

class Q2_1804 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("S1", Student.Grade.A),
                new Student("S2", Student.Grade.A),
                new Student("S3", Student.Grade.C)
        );

        Map<Student.Grade, List<Student>> groupingStudents =
                list.stream()
                        .collect(
                                Collectors.groupingBy(Student::getGrade)
                        );

        System.out.println(groupingStudents);

        Map<Student.Grade, List<String>> groupingNames =
                list.stream()
                        .collect(Collectors.groupingBy(
                           Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        System.out.println(groupingNames);
    }
}
