package operation;

import model.Menu;
import model.Order;
import java.io.*;
import java.util.Scanner;

public class OrderOperation {

    public static String ordersPath = "/Users/sudeep-macmini/IdeaProjects/root/resturantAdminPortal/src/main/resources/orders.txt";

    public void takeOrder(Menu[] menus) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ordersPath, true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Place an Order:");

            int orderNumber = 1;

            do {
                System.out.println("Menu Items:");
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "Menu Id", "Item Name", "Description", "Price", "Date");

               /* for (Menu menu : menus) {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                            menu.getMenuId(),
                            menu.getMenuName(),
                            menu.getMenuDescription(),
                            menu.getPrice(),
                            menu.date);
                }*/

                System.out.print("Enter the menu number (0 to finish): ");
                int menuNumber = scanner.nextInt();

                if (menuNumber == 0) {
                    break; // Exit the loop if the customer is done ordering
                }

                if (menuNumber < 1 || menuNumber > menus.length) {
                    System.out.println("Invalid menu number. Please choose a valid option.");
                    continue;
                }

                Menu selectedMenu = menus[menuNumber - 1];

                System.out.print("Enter quantity for " + selectedMenu.getMenuName() + ": ");
                int quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Please enter a positive number.");
                    continue;
                }

                Order order = new Order();
                order.setItemName(selectedMenu.getMenuName());
                order.setPrice(selectedMenu.getPrice());
                order.setQty(quantity);
                order.setTotalAmount(selectedMenu.getPrice() * quantity);
                order.setDate(order.getDate());

                // Write the order details to the file
                writer.write(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%n",
                        order.getOrderId(),
                        order.getItemName(),
                        order.getPrice(),
                        order.getQty(),
                        order.getTotalAmount(),
                        order.getDate()));
                writer.newLine();


                System.out.println("Order placed successfully for " + selectedMenu.getMenuName());

                orderNumber++;


            } while (true);

        } catch (Exception e) {
            System.err.println("Error Message :: " + e.getMessage());
        }
    }
}













    /*public void writeOrdersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ordersPath))) {
            // Write the header
            writer.write("OrderId,ItemName,Price,Quantity,TotalAmount,Date");
            writer.newLine();

            // Write each order to the file
            for (Order order : orders) {
                writer.write(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%n",
                        order.getOrderId(),
                        order.getItemName(),
                        order.getPrice(),
                        order.getQty(),
                        order.getTotalAmount(),
                        order.getDate()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing orders to file: " + e.getMessage());
        }
    }*/

