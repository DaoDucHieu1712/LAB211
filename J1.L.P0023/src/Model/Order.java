/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Order {

    private String customer;
    private ArrayList<Fruit> OrderList;

    public Order() {
        OrderList = new ArrayList<>();
    }

    public Order(ArrayList<Fruit> OrderList, String customer) {
        this.OrderList = OrderList;
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Fruit> getOrderList() {
        return OrderList;
    }

    public void setOrderList(ArrayList<Fruit> OrderList) {
        this.OrderList = OrderList;
    }

    public void updateOrder(int quantity, Fruit f, int id) {
        boolean check = false;
        // oder trung 
        for (Fruit od : OrderList) {
            if (id == od.getId()) {
                check = true;
                od.setQuantity(od.getQuantity() + quantity);// set quantity order
                f.setQuantity(f.getQuantity() - quantity); //set quantity fruit
                break;
            }
        }
       
        if(check == false){
            Fruit od = new Fruit(f.getId(), f.getName(), f.getPrice(), quantity, f.getOrigin());
            OrderList.add(od);
            f.setQuantity(f.getQuantity() - quantity);
        }
    }
}
