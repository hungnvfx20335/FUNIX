import models.Student;

import java.util.*;

public class Main {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V1.0.0";
    public static final Scanner input = new Scanner(System.in);
    public static final ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        displayInformation();
        while (input.hasNextLine()) {
            String number = input.nextLine();
            if (checkNumber(number)) {
                int checkedNumber = Integer.parseInt(number);
                switch (checkedNumber) {
                    case 1:
                        System.out.print("Nhập id: ");
                        String id = input.nextLine();
                        addStudent(id);
                        if (checkNumberStudent(students.size())) {
                            System.out.println("Bạn có muốn học tiếp (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
                            String select = input.nextLine().toUpperCase();
                            switch (select) {
                                case "Y":
                                    System.out.print("Nhập id: ");
                                    id = input.nextLine();
                                    addStudent(id);
                                    break;
                                case "N":
                                    displayInformation();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        searchStudent();
                        break;
                    case 3:
                        sortedStudent();
                        break;
                    case 4:
                        updateDeleteStudent();
                        break;
                    case 5:
                        displayStudent();
                        break;
                    case 0:
                        System.exit(0);
                }
                System.out.print("Chọn chức năng: ");
            } else {
                System.out.print("Chọn chức năng: ");
            }
        }
    }
    public static void displayInformation() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "Quản Lý Sinh Viên" + " | " + AUTHOR + VERSION + "    |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Thêm sinh viên                             |");
        System.out.println("| 2. Tìm kiếm theo tên sinh viên                |");
        System.out.println("| 3. Sắp xếp theo tên sinh viên                 |");
        System.out.println("| 4. Cập nhật và xóa sinh viên theo id          |");
        System.out.println("| 5. Hiển thị thông tin sinh viên               |");
        System.out.println("| 0. Thoát                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }
    public static boolean checkNumber(String number) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(number);
            if (inputNumber > 5 || inputNumber < 0) {
                System.out.println("Nhập chức năng không đúng.");
                return false;
            }
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("Nhập chức năng không đúng.");
            return false;
        }
    }
    public static void addStudent(String id) {
        Student existingStudent = findID(id);
        if (existingStudent == null) {
            System.out.print("Nhập tên sinh viên: ");
            String studentName = input.nextLine();
            System.out.print("Nhập học kỳ của sinh viên: ");
            String semester = input.nextLine();
            System.out.print("Nhập tên khóa học: ");
            String courseName = input.nextLine();
            students.add(new Student(id, studentName, semester, courseName));
        } else {
            System.out.println("Sinh viên này đã có.");
        }
    }
    public static boolean checkNumberStudent(int number) {
        return number > 9;
    }
    public static Student findID(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
    public static void searchStudent() {
        System.out.println("Nhập tên sinh viên:");
        String studentName = input.nextLine().toUpperCase();
        String answer = "Tên sinh viên không tồn tại";
        for (Student student : students) {
            if (student.getStudentName().toUpperCase().contains(studentName)) {
                answer = student.toString();
                break;
            }
        }
        System.out.println(answer);
    }
    public static void sortedStudent() {
        students.sort(Comparator.comparing(Student::getStudentName));
        displayInformationStudent();
    }
    public static void updateDeleteStudent() {
        System.out.println("Nhập id sinh viên:");
        String id = input.nextLine();
        searchId(id);
        System.out.println("Bạn muốn cập nhật (U) hay xóa (D) học sinh");
        String select = input.nextLine().toUpperCase();
        if (select.equals("U")) {
            for (Student student : students) {
                if (student.getId().equalsIgnoreCase(id)) {
                    student.updateStudent(id);
                    System.out.println("Thông tin sinh viên được cập nhật");
                    searchId(id);
                }
            }
        } else if (select.equals("D")) {
            System.out.println("Thông tin sinh viên bị xóa:");
            students.remove(searchId(id));
        }
    }
    public static Student  searchId(String id) {
        StringBuilder answer = new StringBuilder("Thông tin sinh viên\n");
        for (Student student : students) {
            if (student.getId().equals(id)) {
                answer.append(student);
                System.out.println(answer);
                return student;
            }
        }
        return null;
    }
    public static void displayStudent() {
        int number;
        StringBuilder answer = new StringBuilder("Thông tin sinh viên\n");
        students.sort(Comparator.comparing(Student::getStudentName));
        HashMap<String, String> totalNumberCourseStudent = new HashMap<>();
        for (int i = 0; i < students.size() - 1; i++) {
            Student student = students.get(i);
            Student student1 = students.get(i + 1);
            number = 1;

            if (student.getStudentName().equalsIgnoreCase(student1.getStudentName()) && student.getCourseName().
                    equalsIgnoreCase(student1.getCourseName())) {
                number++;
                totalNumberCourseStudent.put(students.get(i).getStudentName() + " | " + students.get(i).getCourseName(), String.valueOf(number));
            } else if (!student.getStudentName().equalsIgnoreCase(student1.getStudentName()) && student.getCourseName().
                    equalsIgnoreCase(student1.getCourseName()) && i == 0) {
                totalNumberCourseStudent.put(students.get(i).getStudentName() + " | " + students.get(i).getCourseName(), String.valueOf(number));
                totalNumberCourseStudent.put(students.get(i + 1).getStudentName() + " | " + students.get(i + 1).getCourseName(), String.valueOf(number));
            } else {
                totalNumberCourseStudent.put(students.get(i + 1).getStudentName() + " | " + students.get(i + 1).getCourseName(), String.valueOf(number));
            }

        }
        for (Map.Entry<String, String> entry : totalNumberCourseStudent.entrySet()) {
            answer.append(entry.getKey()).append(" | ").append(entry.getValue()).append("\n");
        }
        System.out.println(answer);
    }

    public static void displayInformationStudent() {
        StringBuilder answer = new StringBuilder("Thông tin sinh viên\n");
        for (Student student : students) {
            answer.append(student.toString());
        }
        System.out.println(answer);
    }
}