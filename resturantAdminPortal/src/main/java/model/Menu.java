package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu {

    public static int id=100;
    public String menuId;
    public String menuName;
    public String menuDescription;
    public double price;
    public String date;

    public Menu() {
        this.menuId = "Resturant" + id++;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
