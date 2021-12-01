/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Order;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class OrderManagement {

    Hashtable<String, Order> orderDetail = new Hashtable<>(); 
    private int roll = 0;
    
    public Hashtable<String, Order> getOrderDetail(){
        return orderDetail;
    }
    
    public void addOrder(Order o){ 
        roll++;
        orderDetail.put(o.getCustomer() + "#" +roll , o);
    }
    
    // In ra Hoa don
    public void displayViewOrder() {
         for (Map.Entry<String, Order> entry : orderDetail.entrySet()) {
            String name = entry.getKey();
            Order o = entry.getValue();
            System.out.println("Customer: "+ name);
            double total = 0;
            System.out.printf("%-2s%-20s%-20s%-20s%-20s\n","","Product","Quantity","Price","Amount");
            for (int i = 0; i < o.getOrderList().size(); i++) {
                 total += o.getOrderList().get(i).getAmount();
                 System.out.printf("%-2s%-20s%-20s%-20s%-20s\n",i+1+".",
                         o.getOrderList().get(i).getName(),
                         o.getOrderList().get(i).getQuantity(),
                         o.getOrderList().get(i).getPrice()+"$",
                         o.getOrderList().get(i).getAmount()+"$");
             }
             System.out.println("Total: "+total+"$");
        }
         

    }

}
