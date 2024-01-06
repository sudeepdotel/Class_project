package xmlBased.model;



import lombok.Data;


@Data
public class Department {

    private int deptId;
    private String deptName;
    public void validateDepartmentName() {
        System.out.println("Validating Department Name...");
    }

    public void getDepartmentData() {
        System.out.println("Getting Department Data...");
    }
}
