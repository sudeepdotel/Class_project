package annotationBased.execution;

import annotationBased.model.Institute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExecution1 {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext (Config.class);

        Institute institute = context.getBean(Institute.class);

        institute.init ();


    }

}
