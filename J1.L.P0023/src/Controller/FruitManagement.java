/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Fruit;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class FruitManagement {

    private ArrayList<Fruit> listFruit = new ArrayList<>();

    public FruitManagement() {
        listFruit.add(new Fruit(1, "Coconut", 2d, 10, "Vietnam"));
        listFruit.add(new Fruit(2, "Orange", 3d, 10, "US"));
        listFruit.add(new Fruit(3, "Apple", 4d, 10, "Thailand"));
        listFruit.add(new Fruit(4, "Grape", 6d, 10, "France"));
    }

    // add Fruit in List
    public int createFruit(String name, double price, int quantity, String origin) {
        int id = 0;
        if (listFruit.isEmpty()) {
            id = 1;
        } else {
            id = listFruit.get(listFruit.size() - 1).getId() + 1;
        }
        listFruit.add(new Fruit(id, name, price, quantity, origin));
        return id;
    }

    // goi den listFruit
    public ArrayList<Fruit> getFruitList() {
        return listFruit;
    }

    // SEARCH doi tuong THEO id
    public Fruit FruitByID(int id) {
        for (Fruit f : listFruit) {
            if (id == f.getId()) {
                return f;
            }
        }
        return null;
    }

    // Search doi tuong theo Name
    public Fruit FruitByName(String name) {
        for (Fruit f : listFruit) {
            if (name.equalsIgnoreCase(f.getName())) {
                return f;
            }
        }
        return null;
    }

    // check Name exist
    public boolean checkFruitName(String name) {
        for (Fruit f : listFruit) {
            if (name.equalsIgnoreCase(f.getName())) {
                return true;
            }
        }
        return false;
    }

    //checkID ton tai
    public boolean checkFruitID(int id) {
        for (Fruit f : listFruit) {
            if (id == f.getId()) {
                return true;
            }
        }
        return false;
    }

    // hien thi thong tin cua Danh sach Fruit
    public void displayListFruit() {
        System.out.println("List Fruit: ");
        System.out.printf("%-10s%-15s%-15s%-15s%-15s\n",
                "Item", "Fruit Name", "Origin", "Price", "Quantity");
        for (int i = 0; i < listFruit.size(); i++) {
            Fruit f = listFruit.get(i);
            System.out.printf("%-10s%-15s%-15s%-15s%-15s\n", f.getId(), f.getName(),
                    f.getOrigin(), f.getPrice() + "$", f.getQuantity());
        }
        System.out.println();
    }

}
