/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Validate;

/**
 *
 * @author ADMIN
 */
public class View {

    public static void run() {
        Option op = new Option();
        while (true) {
            op.menu();
            int choice = Validate.getChoice("Choose: ", "Invalid !", 1, 4);
            switch (choice) {
                case 1:
                    op.addFruit();
                    break;
                case 2:
                    op.viewOrder();
                    break;
                case 3:
                    op.Shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

}
