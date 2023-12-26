package service;

import dao.DailyExpensesDAO;
import model.DailyExpenses;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

public class DailyExpensesService {

    private final DailyExpensesDAO dailyExpensesDAO;

    public DailyExpensesService( SessionFactory sessionFactory) {
        this.dailyExpensesDAO = new DailyExpensesDAO(sessionFactory);
    }

    public void saveDailyExpense( DailyExpenses dailyExpense) {
        dailyExpensesDAO.saveDailyExpense(dailyExpense);
    }

    public List<DailyExpenses> getExpensesByDate( LocalDateTime date) {
        return dailyExpensesDAO.getExpensesByDate(date);
    }
}
