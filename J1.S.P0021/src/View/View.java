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
            int choice = Validate.getChoice("Choice: ", "Choice 1->5", 1, 5);
            switch(choice){
                case 1:
                    op.createStudent();
                    break;
                case 2:
                    op.FindAndSortStudent();
                    break;
                case 3:
                    op.UpdateORDelete();
                    break;
                case 4:
                    op.Report();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
