package operation;

import model.Menu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class MenuOperation {
    public static String menuPath = "/Users/sudeep-macmini/IdeaProjects/root/resturantAdminPortal/src/main/resources/menu.txt";
    public static void addMenu(Menu[] menus) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(menuPath, true))) {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < menus.length; i++) {
                Menu menu = new Menu();
                System.out.print("Enter Menu Name: ");
                String itemName = scanner.next();
                menu.setMenuName(itemName);
                System.out.print("Enter Menu Description: ");
                String itemDescription = scanner.next();
                menu.setMenuDescription(itemDescription);
                System.out.print("Enter Menu Price: ");
                double price = scanner.nextDouble();
                menu.setPrice(price);
                menus[i] = menu;

                // Write the menu details to the file
                writer.write(String.format("%-20s%-20s%-20s%-20s%-20s%n",
                        menu.getMenuId(),
                        menu.getMenuName(),
                        menu.getMenuDescription(),
                        menu.getPrice(),
                        menu.date));
            }

            System.out.println("Menus added successfully to the file.");


        } catch (Exception e) {
            System.err.println("Error Message :: " + e.getMessage());
        }
    }

    public static void displayMenu(Menu[] menus) {
        System.out.println("Menu Items List : ");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "Menu Id", "Item Name", "Description", "Price", "Date");
        for (Menu mnu : menus) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                    mnu.getMenuId(),
                    mnu.getMenuName(),
                    mnu.getMenuDescription(),
                    mnu.getPrice(),
                    mnu.date);
        }
    }
}
