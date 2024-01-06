package annotationBased.execution;

import annotationBased.model.Department;
import annotationBased.model.Institute;
import annotationBased.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean(name = "student")
    @Scope(value = "prototype")
    public Student student() {
        return new Student();
    }

    @Bean(name = "department")
    @Scope(value = "prototype")
    public Department department() {
        return new Department();
    }

    @Bean(name = "institute")
    @Scope(value = "singleton")
    public Institute institute(Student student, Department department) {
        return new Institute(student, department);
    }
}

