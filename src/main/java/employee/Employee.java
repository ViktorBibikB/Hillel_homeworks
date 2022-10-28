package employee;

public class Employee {
    private String fullName;
    private String jobTitle;
    private ContactInfo contactInfo;
    private int age;

    public Employee(String fullName, String jobTitle, ContactInfo contactInfo, int age){
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.contactInfo = contactInfo;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", contactInfo=" + contactInfo +
                ", age=" + age +
                '}';
    }
}
