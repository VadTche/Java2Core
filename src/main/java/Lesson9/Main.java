package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList());
        Course course = () -> null;

        List<String> uniqCourse = uniqCourse(students.stream());
        List<String> tripleOfCurious = tripleOfCurious(students.stream());
        List<String> studentsOfThatCourse = studentsOfThatCourse(students.stream(), course);
        System.out.println(uniqCourse);
        System.out.println(tripleOfCurious);
        System.out.println(studentsOfThatCourse);

    }

    static List<String> uniqCourse(Stream<Student> students) {
        return students
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    static List<String> tripleOfCurious(Stream<Student> students) {
        return students
                .sorted(Comparator.comparingInt(o -> o.getAllCourses().size()))
                .limit(3)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    static List<String> studentsOfThatCourse(Stream<Student> students, Course course) {
        return students
                .filter(student -> student.getAllCourses().stream().anyMatch(courses -> courses.getName().equals(course.getName())))
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
