package execution;

import model.Menu;
import operation.MenuOperation;
import operation.OrderOperation;
import operation.ReceiptGenerator;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {

    static Logger log = Logger.getLogger ( Main.class.getName () );
    public static void main(String[] args) {
        System.out.println("Welcome to Zorba Restaurant portal");
        OrderOperation orderOperation = new OrderOperation();
        Menu[] menus = new Menu[3];
        MenuOperation.addMenu(menus);
        MenuOperation.displayMenu(menus);

        Scanner scanner = new Scanner(System.in);

        do {
            orderOperation.takeOrder(menus);
            System.out.println("Do you want to place another order? (1 for yes, 0 for no): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
        } while (true);

        // Generate receipts based on the orders
        ReceiptGenerator.generateReceipt();
        log.info ( orderOperation );
    }
}
