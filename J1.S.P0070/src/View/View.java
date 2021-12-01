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
    
    public static void run(){
        Option op = new Option();
        while (true) {            
            Option.menu();
            int choice = Validate.getChoice("Please choice one option: ", "Choice 1 -> 3", 1, 3);
            switch(choice){
                case 1:
                    op.LoginVi();
                    break;
                case 2:
                    op.LoginEn();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
