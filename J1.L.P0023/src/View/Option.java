/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.FruitManagement;
import Controller.OrderManagement;
import Controller.Validate;
import Model.Fruit;
import Model.Order;

/**
 *
 * @author ADMIN
 */
public class Option {

    private FruitManagement fmn = new FruitManagement();
    private OrderManagement omn = new OrderManagement();

    void menu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit\n"
                + " (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
    }

    public void addFruit() {
        System.out.println("---------Add Fruit--------");
        while (true) {
            String name = Validate.getString("Enter Fruit Name: ", "Invalid !");
            if (fmn.checkFruitName(name) == true) {  // neu fruit da co thi chi bonus them so luong
                Fruit f = fmn.FruitByName(name);
                int quantitybonus = Validate.getInt("Quantity bonus:", "quantity > 0");
                int quantity = f.getQuantity() + quantitybonus;
                f.setQuantity(quantity);
            } else {
                double price = Validate.getDouble("Price: ", "Price > 0");
                int quantity = Validate.getInt("Quantity: ", "Quantity > 0");
                String origin = Validate.getString("Origin: ", "Invalid !");
                fmn.createFruit(name, price, quantity, origin);
            }
            if (Validate.checkInputYN("Do you want to continue (Y/N) ?") == false) {
                break;
            }
        }
        System.out.println();
        fmn.displayListFruit();
        System.out.println();
    }

    void viewOrder() {
        System.out.println("--------View Order--------");
        if (omn.getOrderDetail().isEmpty()) {
            System.out.println("View Order Empty !");
            return;
        }
        omn.displayViewOrder();
        System.out.println();
    }

    void Shopping() {
        Order o = new Order();
        System.out.println("--------Shopping---------");
        if (fmn.getFruitList().isEmpty()) {
            System.out.println("Out of stock.");
            return;
        }
        while (true) {
            fmn.displayListFruit();
            int item;
            while (true) {
                item = Validate.getInt("Choice Item you want buy: ", "Invalid !"); //check input id phai ton tai trong list
                if (fmn.checkFruitID(item) == true) {
                    break;
                } else {
                    System.out.println("Out Range !");
                }
            }
            Fruit f = fmn.FruitByID(item);
            System.out.println("You selected: " + f.getName());
            int quantity = Validate.getChoice("Quantity you want buy: ",
                    "Invalid !", 1, f.getQuantity());
            o.updateOrder(quantity, f, item);
            if (f.getQuantity() == 0) {
                fmn.getFruitList().remove(f);
            }
            //neu cua hang khong con gi de ban
            if (fmn.getFruitList().isEmpty()) {
                System.out.println("Shop Out of stock !");
                break;
            }
            if (Validate.checkInputYN("Do you want to order now (Y/N)") == true) {
                break;
            }
        }

        System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
        double sum = 0;
        for (int i = 0; i < o.getOrderList().size(); i++) {
            Fruit od = o.getOrderList().get(i);
            sum += od.getAmount();
            System.out.printf("%-20s%-20s%-20s%-20s\n", od.getName(),
                    od.getQuantity(), od.getPrice() + "$", od.getAmount() + "$");
        }
        System.out.println("Total: " + sum + "$");
        System.out.println();
        String name = Validate.getString("Input your name: ", "Invalid !"); // nhap ten customer
        o.setCustomer(name);
        omn.addOrder(o);
        System.out.println("Thanks you !");
        System.out.println();
    }
}
