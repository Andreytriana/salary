public class Empleado {

    private String jobTitle;
    private double experienceYears;
    private String educationLevel;
    private int skillsCount;
    private String industry;
    private String companySize;
    private String location;
    private String remoteWork;
    private int certifications;
    private double salary;

    public Empleado(String jobTitle, double experienceYears,
                    String educationLevel, int skillsCount,
                    String industry, String companySize,
                    String location, String remoteWork,
                    int certifications, double salary) {

        this.jobTitle = jobTitle;
        this.experienceYears = experienceYears;
        this.educationLevel = educationLevel;
        this.skillsCount = skillsCount;
        this.industry = industry;
        this.companySize = companySize;
        this.location = location;
        this.remoteWork = remoteWork;
        this.certifications = certifications;
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public int getSkillsCount() {
        return skillsCount;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCompanySize() {
        return companySize;
    }

    public String getLocation() {
        return location;
    }

    public String getRemoteWork() {
        return remoteWork;
    }

    public int getCertifications() {
        return certifications;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "jobTitle='" + jobTitle + '\'' +
                ", experienceYears=" + experienceYears +
                ", educationLevel='" + educationLevel + '\'' +
                ", skillsCount=" + skillsCount +
                ", industry='" + industry + '\'' +
                ", companySize='" + companySize + '\'' +
                ", location='" + location + '\'' +
                ", remoteWork='" + remoteWork + '\'' +
                ", certifications=" + certifications +
                ", salary=" + salary +
                '}';
    }
}