package org.nepalimarket.fullstackproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nepalimarket.fullstackproject.model.Student;
import org.nepalimarket.fullstackproject.util.HibernateConnection;

public class StudentDao {

    private final SessionFactory sessionFactory;

    public StudentDao ( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudent( Student student){
        Session session = HibernateConnection.getSessionFactory ( ).openSession ( );

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
        }

    }
}
