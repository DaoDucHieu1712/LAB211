/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Management;
import Controller.Validate;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Management mn = new Management();
        while (true) {
            Management.menu();
            int choice = Validate.getChoice("Choice: ", "Input: 1->4 !!!", 1, 4);
            switch (choice) {
                case 1:
                    mn.ADD();
                    break;
                case 2:
                    mn.deleteTask();
                    break;
                case 3:
                    mn.getDataTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }
}
