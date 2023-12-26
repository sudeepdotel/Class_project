import model.DailyExpenses;
import service.DailyExpensesService;
import util.HibernateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class MainExecutionTest2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter expense name: ");
        String expenseName = scanner.nextLine();

        System.out.print("Enter date time (yyyy-MM-dd HH:mm:ss): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse ( dateTimeStr );

        //need better date formatting

        System.out.print("Enter purpose: ");
        String purpose = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        // Create DailyExpenses object
        DailyExpenses dailyExpenses = new DailyExpenses();
        dailyExpenses.setExpenseName(expenseName);
        dailyExpenses.setDateTime(localDateTime);
        dailyExpenses.setPurpose(purpose);
        dailyExpenses.setAmount(amount);

        // Save the expense using the DailyExpensesService
        DailyExpensesService dailyExpensesService = new DailyExpensesService( HibernateUtils.getSessionFactory());
        dailyExpensesService.saveDailyExpense(dailyExpenses);

        System.out.println("Expense added successfully!");
    }

    private static String parseDateTime ( String dateTimeStr ) {

        SimpleDateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
        return dateFormat.format ( dateTimeStr );
    }


}
