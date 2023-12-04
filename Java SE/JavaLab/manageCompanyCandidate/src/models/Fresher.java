package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fresher extends Candidate{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String candidateCode, String candidateLastName, String candidateName, String candidateBirthday, String candidateAddress,
                   String candidatePhone, String candidateEmail, String candidateType, String graduationDate, String graduationRank, String education) {
        super(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail, candidateType);
        this.setGraduationDate(graduationDate);
        this.setGraduationRank(graduationRank);
        this.setEducation(education);
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        if (checkDataGraduationRank(graduationRank)) {
            this.graduationRank = graduationRank;
        } else {
            updateDataGraduationRank();
        }
    }
    public boolean checkDataGraduationRank(String dataGraduationRank) {
        String regex = "Xuất sắc|Tốt|Khá|Kém$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dataGraduationRank);
        return matcher.matches();
    }
    public void updateDataGraduationRank() {
        System.out.println("Nhập xếp hạng tốt nghiệp không đúng định dạng");
        System.out.println("Nhập xếp hạng tốt nghiệp:");
        while (input.hasNextLine()) {
            String enterAgainDataGraduationRank = input.nextLine();
            if (checkDataGraduationRank(enterAgainDataGraduationRank)) {
                this.graduationRank = enterAgainDataGraduationRank;
                return;
            } else {
                System.out.println("Nhập xếp hạng tốt nghiệp không đúng định dạng");
                System.out.println("Nhập xếp hạng tốt nghiệp:");
            }
        }
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    public String toString() {
        return String.format("%-10s%-10s%-10s%-20s%-15s%-20s%-30s%-10s%-20s%-20s%-20s%n", getCandidateCode(), getCandidateLastName(), getCandidateName(),
                getCandidateBirthday(), getCandidateAddress(), getCandidatePhone(), getCandidateEmail(), getCandidateType(),
                getGraduationDate(), getGraduationRank(), getEducation());
    }
}
