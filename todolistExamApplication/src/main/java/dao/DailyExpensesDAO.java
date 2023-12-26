package dao;

import model.DailyExpenses;
import model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class DailyExpensesDAO {

    private final SessionFactory sessionFactory;

    public DailyExpensesDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveDailyExpense( DailyExpenses dailyExpense) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(dailyExpense);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public List<DailyExpenses> getExpensesByDate ( LocalDateTime date ) {

        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM DailyExpenses d WHERE d.dateTime = :date";
            return session.createQuery(hql, DailyExpenses.class)
                    .setParameter("date", date)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
