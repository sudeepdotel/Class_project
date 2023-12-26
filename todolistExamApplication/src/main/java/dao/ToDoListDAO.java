package dao;

import model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.sql.Date;
import java.util.List;

public class ToDoListDAO {

    private final SessionFactory sessionFactory;

    public ToDoListDAO ( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    public void saveToDoTask ( Task task ) {
        Session session = HibernateUtils.getSessionFactory ( ).openSession ( );
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction ( );
            session.save ( task );
            transaction.commit ( );
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback ( );
            }
            e.printStackTrace ( );
        } finally {
            if (session != null) {
                session.close ( );
            }
        }
    }

    public List<Task> getTasksByDate ( Date date ) {
        Session session = HibernateUtils.getSessionFactory ( ).openSession ( );
        try {
            return session.createQuery ( "FROM Task WHERE taskDate = :date", Task.class )
                    .setParameter ( "date", date )
                    .getResultList ( );
        } finally {
            if (session != null) {
                session.close ( );
            }
        }


    }
}
