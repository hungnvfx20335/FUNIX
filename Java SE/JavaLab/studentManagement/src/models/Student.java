package models;

import java.util.Scanner;

public class Student {
    private String id;
    private String studentName;
    private String semester;
    private String courseName;
    public static final Scanner input = new Scanner(System.in);
    public Student(String id, String studentName, String semester, String courseName) {
        this.setId(id);
        this.setStudentName(studentName);
        this.setSemester(semester);
        this.setCourseName(courseName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String toString() {
        return String.format("%-20s%-20s%-20s%n", getStudentName(), getSemester(), getCourseName());
    }
    public void updateStudent(String id) {
        if (id != null && id.equalsIgnoreCase("")) {
            this.setId(id);
        }
        System.out.print("Nhập tên sinh viên: ");
        String studentName = input.nextLine();
        this.setCourseName(studentName);
        System.out.print("Nhập học kỳ của sinh viên: ");
        String semester = input.nextLine();
        this.setSemester(semester);
        System.out.print("Nhập tên khóa học: ");
        String courseName = input.nextLine();
        this.setCourseName(courseName);
    }
}
