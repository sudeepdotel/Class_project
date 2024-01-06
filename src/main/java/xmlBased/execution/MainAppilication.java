package xmlBased.execution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlBased.model.Institute;
import xmlBased.model.Student;

public class MainAppilication {


    public static void main(String[] args) {
       ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

//        Student student = context.getBean ( "student" , Student.class);
//        student.getStudentData ();
//        student.validateStudentId ();
//        student.validateStudentName ();

        Institute institute = context.getBean("institute", Institute.class);
        institute.instituteOperations();



    }
}
