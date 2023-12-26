package org.nepalimarket.fullstackproject.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nepalimarket.fullstackproject.model.Student;
import org.nepalimarket.fullstackproject.model.StudentResult;


public class HibernateConnection {

    @Getter
    public static final SessionFactory sessionFactory ;

    static {
        try {

            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass ( Student.class )
                    .addAnnotatedClass ( StudentResult.class )
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
