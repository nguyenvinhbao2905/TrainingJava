package homework.datatypes.studentmanager;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Student {
    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    private float score;
    private Academic academicYear;

    public enum Academic {
        EXCELLENT, GOOD, AVERAGE, WEAK;
    }

    public Student(){
    }
    public Student(String name, float score) {
        this.name = name;
        this.score = score;
        this.academicYear = setAcademicYear(score);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", academicYear=" + academicYear +
                '}';
    }

    public ArrayList<Student> insertStudent() {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Enter number of students: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student score: ");
            float score = sc.nextFloat();
            sc.nextLine();
            students.add(new Student(name, score));
        }

        return students;
    }


    public void printStudents(ArrayList<Student> students) {
        students.forEach(System.out::println);
    }



    public Student findStudentHasMaxScore(ArrayList<Student> students) {
        return students.stream().
                max(Comparator.comparing(Student::getScore))
                .orElse(null);


//        Student topStudentScore = students.get(0);
//
//        for (Student student : students) {
//            if (student.getScore() > topStudentScore.getScore()) {
//                topStudentScore = student;
//            }
//        }
//        return topStudentScore;
    }

    public void sortStudent(ArrayList<Student> students) {
        students.sort(Comparator.comparing(Student::getScore).reversed());
    }
    private Academic setAcademicYear(float score) {
        if (score >= 8.5) return Academic.EXCELLENT;
        if (score >= 7 || score <= 8.4) return Academic.GOOD;
        if (score >= 5 || score <= 6.9) return Academic.AVERAGE;
        return Academic.WEAK;
    }
}
