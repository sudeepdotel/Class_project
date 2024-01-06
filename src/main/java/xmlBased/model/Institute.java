package xmlBased.model;



import lombok.Data;

@Data
public class Institute {
    private Student student;
    private Department department;

    public void instituteOperations() {
        student.validateStudentId();
        student.validateStudentName();
        student.getStudentData();

        department.validateDepartmentName();
        department.getDepartmentData();
    }
}
