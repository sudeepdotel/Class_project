package execution;

import model.Menu;
import operation.MenuOperation;
import operation.OrderOperation;
import operation.ReceiptGenerator;

import java.util.Scanner;

public class Main {
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
            // Add logic to read user input and decide whether to continue taking orders
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;  // Exit the loop if the user enters 0
            }
        } while (true);

        // Generate receipts based on the orders
        ReceiptGenerator.generateReceipt();
    }
}
