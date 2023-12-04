package models;

public class Intern extends Candidate{
    private String major;
    private String semester;
    private String universityName;
    public Intern(String candidateCode, String candidateLastName, String candidateName, String candidateBirthday, String candidateAddress,
                  String candidatePhone, String candidateEmail, String candidateType, String major, String semester, String universityName) {
        super(candidateCode, candidateLastName, candidateName, candidateBirthday, candidateAddress, candidatePhone, candidateEmail, candidateType);
        this.setMajor(major);
        this.setSemester(semester);
        this.setUniversityName(universityName);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String toString() {
        return String.format("%-10s%-10s%-10s%-20s%-15s%-20s%-30s%-10s%-20s%-20s%-20s%n", getCandidateCode(), getCandidateLastName(), getCandidateName(),
                getCandidateBirthday(), getCandidateAddress(), getCandidatePhone(), getCandidateEmail(), getCandidateType(),
                getMajor(), getSemester(), getUniversityName());
    }
}
