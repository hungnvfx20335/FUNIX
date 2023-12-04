package models;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Candidate {
    private String candidateCode;
    private String candidateLastName;
    private String candidateName;
    private String candidateBirthday;
    private String candidateAddress;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateType;
    public Scanner input = new Scanner(System.in);
    public Candidate(String candidateCode, String candidateLastName, String candidateName, String candidateBirthday, String candidateAddress,
                     String candidatePhone, String candidateEmail, String candidateType) {
        this.setCandidateCode(candidateCode);
        this.setCandidateLastName(candidateLastName);
        this.setCandidateName(candidateName);
        this.setCandidateBirthday(candidateBirthday);
        this.setCandidateAddress(candidateAddress);
        this.setCandidatePhone(candidatePhone);
        this.setCandidateEmail(candidateEmail);
        this.setCandidateType(candidateType);
    }

    public String getCandidateCode() {
        return candidateCode;
    }

    public void setCandidateCode(String candidateCode) {
        this.candidateCode = candidateCode;
    }

    public String getCandidateLastName() {
        return candidateLastName;
    }

    public void setCandidateLastName(String candidateLastName) {
        this.candidateLastName = candidateLastName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateBirthday() {
        return candidateBirthday;
    }

    public void setCandidateBirthday(String candidateBirthday) {
        if (checkDataBirthday(candidateBirthday)) {
            this.candidateBirthday = candidateBirthday;
        } else {
            updateCandidateBirthday();
        }
    }
    public void updateCandidateBirthday() {
        System.out.println("Nhập ngày sinh không đúng định dạng");
        System.out.println("Nhập ngày sinh:");
        while (input.hasNextLine()) {
            String enterAgainCandidateBirthday = input.nextLine();
            if (checkDataBirthday(enterAgainCandidateBirthday)) {
                this.candidateBirthday = enterAgainCandidateBirthday;
                return;
            } else {
                System.out.println("Nhập ngày sinh không đúng định dạng");
                System.out.println("Nhập ngày sinh:");
            }
        }
    }
    public String getCandidateAddress() {
        return candidateAddress;
    }

    public void setCandidateAddress(String candidateAddress) {
        this.candidateAddress = candidateAddress;
    }

    public String getCandidatePhone() {
        return candidatePhone;
    }

    public void setCandidatePhone(String candidatePhone) {
        if (checkDataPhone(candidatePhone)) {
            this.candidatePhone = candidatePhone;
        } else {
            updateCandidatePhone();
        }
    }
    public void updateCandidatePhone() {
        System.out.println("Nhập số điện thoại không đúng định dạng");
        System.out.println("Nhập số điện thoại:");
        while (input.hasNextLine()) {
            String enterAgainCandidatePhone = input.nextLine();
            if (checkDataPhone(enterAgainCandidatePhone)) {
                this.candidatePhone = enterAgainCandidatePhone;
                return;
            } else {
                System.out.println("Nhập số điện thoại không đúng định dạng");
                System.out.println("Nhập số điện thoại:");
            }
        }
    }
    public boolean checkDataPhone(String dataPhone) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dataPhone);
        return matcher.matches();
    }
    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        if (checkDataEmail(candidateEmail)) {
            this.candidateEmail = candidateEmail;
        } else {
            updateCandidateEmail();
        }
    }
    public boolean checkDataEmail(String email) {
        String regex = "^[a-zA-Z][\\w-]+@(\\w+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public void updateCandidateEmail() {
        System.out.println("Nhập email không đúng định dạng");
        System.out.println("Nhập email:");
        while (input.hasNextLine()) {
            String enterAgainCandidateEmail = input.nextLine();
            if (checkDataEmail(enterAgainCandidateEmail)) {
                this.candidateEmail = enterAgainCandidateEmail;
                return;
            } else {
                System.out.println("Nhập email không đúng định dạng");
                System.out.println("Nhập email:");
            }
        }
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }
    public boolean checkDataBirthday(String birthday) {
        String regex = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthday);
        return matcher.matches();
    }
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", getCandidateCode(), getCandidateLastName(), getCandidateName(),
                getCandidateBirthday(), getCandidateAddress(), getCandidatePhone(), getCandidateEmail(), getCandidateType());
    }
}
