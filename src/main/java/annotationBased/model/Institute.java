package annotationBased.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Institute {

    private final Student student;
    private final Department department;

    @Autowired
    public Institute(Student student, Department department) {
        this.student = student;
        this.department = department;
    }

    public void init() {
        student.validateStudentId();
        student.validateStudentName();
        student.getStudentData();

        department.validateDepartmentName();
        department.getDepartmentData();
    }
}
