package xmlBased.model;


import lombok.Data;

@Data
public class Student {

    private int studId;
    private String studName;

    public void validateStudentId() {
        System.out.println("Validating Student ID...");
    }

    public void validateStudentName() {
        System.out.println("Validating Student Name...");
    }

    public void getStudentData() {
        System.out.println("Getting Student Data...");
    }

    public void init() {
        System.out.println("Inside Init Method for Both....");
    }

    public void destroy() {
        System.out.println("Inside Destroy method for both....");
    }
}