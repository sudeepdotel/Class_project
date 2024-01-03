package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DailyExpenses;
import org.hibernate.SessionFactory;
import service.DailyExpensesService;
import util.HibernateUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/addExpense")
public class ExpensesServlet extends HttpServlet {

    private DailyExpensesService dailyExpensesService;
    private SessionFactory sessionFactory;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String expenseName = request.getParameter("expenseNam");
        String dateTime = request.getParameter ( "expenseDateTime" ) ;
        LocalDateTime dateTime1 = LocalDateTime.parse ( dateTime );

        String purpose = request.getParameter("expensePurpose");
        double amount = Double.parseDouble(request.getParameter("expensesAmount"));

        // Create a DailyExpenses object with fetched details
        DailyExpenses dailyExpense = new DailyExpenses();
        dailyExpense.setExpenseName(expenseName);
        dailyExpense.setDateTime(dateTime1);
        dailyExpense.setPurpose(purpose);
        dailyExpense.setAmount(amount);

        // Initialize DailyExpensesService
        if (dailyExpensesService == null) {
            dailyExpensesService = new DailyExpensesService(sessionFactory);
        }

        try {
            // Save the expense using the DailyExpensesService
            dailyExpensesService.saveDailyExpense(dailyExpense);

            response.getWriter().println("Expense added successfully!");
        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error adding expense. Please check your input.");
        }
    }


}
