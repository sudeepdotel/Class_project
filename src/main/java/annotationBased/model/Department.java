package annotationBased.model;



import org.springframework.stereotype.Component;

@Component
public class Department {
    public void validateDepartmentName() {
        System.out.println("Validating Department Name...");
    }

    public void getDepartmentData() {
        System.out.println("Getting Department Data...");
    }
}
