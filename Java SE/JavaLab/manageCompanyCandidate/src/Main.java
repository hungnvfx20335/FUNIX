import models.Experienced;
import models.Fresher;
import models.Intern;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V1.0.0";
    public static final Scanner input = new Scanner(System.in);
    public static final ArrayList<Experienced> experiences = new ArrayList<>();
    public static final ArrayList<Fresher> freshers = new ArrayList<>();
    public static final ArrayList<Intern> interns = new ArrayList<>();
    public static String candidateCode;
    public static String candidateLastName;
    public static String candidateName;
    public static String candidateBirthday;
    public static String candidateAddress;
    public static String candidatePhone;
    public static String candidateEmail;
    public static String candidateType;
    public static void main(String[] args) {
        displayInformationSoftware();
        while (input.hasNextLine()) {
            String number = input.nextLine();
            if (checkNumber(number)) {
                int checkedNumber = Integer.parseInt(number);
                switch (checkedNumber) {
                    case 1:
                        addExperienced();
                        break;
                    case 2:
                        addFresher();
                        break;
                    case 3:
                        addIntern();
                        break;
                    case 4:
                        System.out.println("Nhập tên ứng viên:");
                        String candidateName = input.nextLine();
                        System.out.println("Nhập loại ứng viên:");
                        String candidateType = input.nextLine();
                        searchCandidate(candidateName, candidateType);
                        break;
                    case 0:
                        System.exit(0);
                }
            } else {
                System.out.print("Chọn chức năng: ");
            }
        }
    }
    public static void displayInformationSoftware() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "Quản Lý ỨNG VIÊN" + " | " + AUTHOR + VERSION + "    |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Thêm ứng viên có kinh nghiệm               |");
        System.out.println("| 2. Thêm ứng viên fresher                      |");
        System.out.println("| 3. Thêm ứng viên intern                       |");
        System.out.println("| 4. Tìm kiếm theo tên và loại ứng viên         |");
        System.out.println("| 0. Thoát                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }
    public static boolean checkNumber(String number) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(number);
            if (inputNumber > 4 || inputNumber < 0) {
                System.out.println("Nhập chức năng không đúng.");
                return false;
            }
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("Nhập chức năng không đúng.");
            return false;
        }
    }
    public static void addExperienced() {
        addCandidate();
        System.out.println("Nhập số năm kinh nghiệm:");
        String experiencedYear = input.nextLine();
        System.out.println("Nhập kỹ năng chuyên môn:");
        String professionalSkill = input.nextLine();
        experiences.add(new Experienced(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail,
                candidateType, experiencedYear, professionalSkill));
        System.out.println("Bạn có muốn tiếp tục (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
        while (input.hasNextLine()) {
            String select = input.nextLine().toUpperCase();
            switch (select) {
                case "Y":
                    addCandidate();
                    System.out.println("Nhập số năm kinh nghiệm:");
                    experiencedYear = input.nextLine();
                    System.out.println("Nhập kỹ năng chuyên môn:");
                    professionalSkill = input.nextLine();
                    experiences.add(new Experienced(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail,
                            candidateType, experiencedYear, professionalSkill));
                    System.out.println("Bạn có muốn tiếp tục (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
                    break;
                case "N":
                    displayInformationSoftware();
                    return;
            }
        }
    }
    public static void addFresher() {
        addCandidate();
        System.out.println("Nhập thời gian tốt nghiệp:");
        String graduationDate = input.nextLine();
        System.out.println("Nhập xếp hạng tốt nghiệp:");
        String graduationRank = input.nextLine();
        System.out.println("Nhập trường đại học sinh viên đã tốt nghiệp:");
        String education = input.nextLine();
        freshers.add(new Fresher(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail,
                candidateType, graduationDate, graduationRank, education));
        System.out.println("Bạn có muốn tiếp tục (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
        while (input.hasNextLine()) {
            String select = input.nextLine().toUpperCase();
            switch (select) {
                case "Y":
                    addCandidate();
                    System.out.println("Nhập thời gian tốt nghiệp:");
                    graduationDate = input.nextLine();
                    System.out.println("Nhập xếp hạng tốt nghiệp:");
                    graduationRank = input.nextLine();
                    System.out.println("Nhập trường đại học sinh viên đã tốt nghiệp:");
                    education = input.nextLine();
                    freshers.add(new Fresher(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail,
                            candidateType, graduationDate, graduationRank, education));
                    System.out.println("Bạn có muốn tiếp tục (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
                    break;
                case "N":
                    displayInformationSoftware();
                    return;
            }
        }
    }
    public static void addIntern() {
        addCandidate();
        System.out.println("Nhập chuyên ngành học:");
        String major = input.nextLine();
        System.out.println("Nhập học kỳ:");
        String semester = input.nextLine();
        System.out.println("Nhập tên trường đại học:");
        String universityName = input.nextLine();
        interns.add(new Intern(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail,
                candidateType, major, semester, universityName));
        System.out.println("Bạn có muốn tiếp tục (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
        while (input.hasNextLine()) {
            String select = input.nextLine().toUpperCase();
            switch (select) {
                case "Y":
                    addCandidate();
                    System.out.println("Nhập chuyên ngành học:");
                    major = input.nextLine();
                    System.out.println("Nhập học kỳ:");
                    semester = input.nextLine();
                    System.out.println("Nhập tên trường đại học:");
                    universityName = input.nextLine();
                    interns.add(new Intern(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail,
                            candidateType, major, semester, universityName));
                    System.out.println("Bạn có muốn tiếp tục (Y/N) không? Chọn Y để tiếp tục, N để quay lại màn hình chính.");
                    break;
                case "N":
                    displayInformationSoftware();
                    return;
            }
        }
    }
    public static void addCandidate() {
        System.out.println("Nhập mã ứng viên:");
        candidateCode = input.nextLine();
        System.out.println("Nhập tên họ ứng viên:");
        candidateLastName = input.nextLine();
        System.out.println("Nhập tên ứng viên:");
        candidateName = input.nextLine();
        System.out.println("Nhập ngày sinh:");
        candidateBirthday = input.nextLine();
        System.out.println("Nhập địa chỉ:");
        candidateAddress = input.nextLine();
        System.out.println("Nhập số điện thoại:");
        candidatePhone = input.nextLine();
        System.out.println("Nhập email:");
        candidateEmail = input.nextLine();
        System.out.println("Nhập loại ứng viên:");
        candidateType = input.nextLine();
    }
    public static void searchCandidate(String candidateName, String candidateType) {
        System.out.println("Danh sách ứng viên:");
        System.out.println("===========ỨNG VIÊN CÓ KINH NGHIỆM============");
        for (Experienced experienced : experiences) {
            System.out.println(experienced.toString());
        }
        System.out.println("==========ỨNG VIÊN FRESHER==============");
        for (Fresher fresher : freshers) {
            System.out.println(fresher.toString());
        }
        System.out.println("===========ỨNG VIÊN THỰC TẬP SINH==============");
        for (Intern intern : interns) {
            System.out.println(intern.toString());
        }
        System.out.println("Các ứng cử viên được tìm thấy:");
        for (Experienced experienced : experiences) {
            if (experienced.getCandidateName().equalsIgnoreCase(candidateName) && experienced.getCandidateType().equalsIgnoreCase(candidateType)) {
                System.out.println(experienced);
            }
        }
        for (Fresher fresher : freshers) {
            if (fresher.getCandidateName().equalsIgnoreCase(candidateName) && fresher.getCandidateType().equalsIgnoreCase(candidateType)) {
                System.out.println(fresher);
            }
        }
        for (Intern intern : interns) {
            if (intern.getCandidateName().equalsIgnoreCase(candidateName) && intern.getCandidateType().equalsIgnoreCase(candidateType)) {
                System.out.println(intern);
            }
        }
        System.out.print("Chọn chức năng: ");
    }
}