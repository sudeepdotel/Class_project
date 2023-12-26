package util;



import lombok.Getter;
import model.DailyExpenses;
import model.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    @Getter
    public static final SessionFactory sessionFactory;

    static {
        try {

            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass ( DailyExpenses.class )
                    .addAnnotatedClass ( Task.class )
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main ( String[] args ) {
        System.out.println (sessionFactory );
    }

}

