package org.nepalimarket.fullstackproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nepalimarket.fullstackproject.model.Student;
import org.nepalimarket.fullstackproject.util.HibernateConnection;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final SessionFactory sessionFactory;

    public StudentDao ( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudent( Student student){
        Session session = HibernateConnection.getSessionFactory ().openSession ( );

        Transaction transaction = null;

        try{
            transaction = session.beginTransaction ();
            session.save ( student );
            transaction.commit ();

        }catch (Exception e ){
            if(transaction != null){
                transaction.rollback ();
            }
            System.err.println ("Error message :: " + e.getMessage () );
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public static List<Student> getAllStudentInfo (   ) {

        Session session = HibernateConnection.getSessionFactory ( ).openSession ( );

        List<Student> students = new ArrayList<> ();

        try{
            students = session.createQuery ( "FROM Student", Student.class ).getResultList ();

        }catch (Exception e ){
            System.err.println ("Error message :: " + e.getMessage () );
        }finally {
            if (session != null) {
                session.close();
            }
        }return students;
    }


}
