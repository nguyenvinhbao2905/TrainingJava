package homework.datatypes.studentmanager;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Đăng", 8.5F));
        students.add(new Student("Minh", 7.0F));
        students.add(new Student("Hùng", 9.2F));

        student.printStudents(students);
        System.out.print("\nStudent has max score: " + student.findStudentHasMaxScore(students));
        System.out.println("Student list after sorted.");
        student.sortStudent(students);
        student.printStudents(students);

        students.addAll(student.insertStudent());
        student.printStudents(students);
    }
}
