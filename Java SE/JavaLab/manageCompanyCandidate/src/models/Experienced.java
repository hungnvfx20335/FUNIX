package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Experienced extends Candidate{
    private String experiencedYear;
    private String professionalSkill;
    public Experienced(String candidateCode, String candidateLastName, String candidateName, String candidateBirthday, String candidateAddress,
                       String candidatePhone, String candidateEmail, String candidateType, String experiencedYear, String professionalSkill) {
        super(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail, candidateType);
        this.setExperiencedYear(experiencedYear);
        this.setProfessionalSkill(professionalSkill);
    }

    public String getExperiencedYear() {
        return experiencedYear;
    }

    public void setExperiencedYear(String experiencedYear) {
        if (checkDataExperiencedYear(experiencedYear)) {
            this.experiencedYear = experiencedYear;
        } else {
            updateDataExperiencedYear();
        }

    }
    public boolean checkDataExperiencedYear(String dataExperiencedYear) {
        String regex = "\\d{1,2}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dataExperiencedYear);
        return matcher.matches();
    }
    public void updateDataExperiencedYear() {
        System.out.println("Nhập số năm kinh nghiệm không đúng định dạng");
        System.out.println("Nhập số năm kinh nghiệm:");
        while (input.hasNextLine()) {
            String enterAgainDataExperiencedYear = input.nextLine();
            if (checkDataExperiencedYear(enterAgainDataExperiencedYear)) {
                this.experiencedYear = enterAgainDataExperiencedYear;
                return;
            } else {
                System.out.println("Nhập số năm kinh nghiệm không đúng định dạng");
                System.out.println("Nhập số năm kinh nghiệm:");
            }
        }
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }
    public String toString() {
        return String.format("%-10s%-10s%-10s%-20s%-15s%-20s%-30s%-10s%-10s%-10s%n", getCandidateCode(), getCandidateLastName(), getCandidateName(),
                getCandidateBirthday(), getCandidateAddress(), getCandidatePhone(), getCandidateEmail(), getCandidateType(), getExperiencedYear(),
                getProfessionalSkill());
    }
}
