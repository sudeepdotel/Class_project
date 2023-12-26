package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DailyExpenses;
import service.DailyExpensesService;
import service.PdfGenerator;
import util.HibernateUtils;


import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/generateExpenseReport")
public class GenerateExpenseReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve date from the request parameters
        String reportDateStr = request.getParameter("reportDate");
        LocalDateTime reportDatetime = LocalDateTime.parse ( reportDateStr );




        // Get expenses for the specified date
        DailyExpensesService expensesService = new DailyExpensesService( HibernateUtils.getSessionFactory());
        List<DailyExpenses> expenses = expensesService.getExpensesByDate(reportDatetime);

        if (!expenses.isEmpty()) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=expense_report.pdf");



            try {
                PdfGenerator.generateExpenseReport(expenses, response.getOutputStream());
                System.out.println("Expense report generated successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("No expenses found for the specified date, try again");
        }
    }


}
