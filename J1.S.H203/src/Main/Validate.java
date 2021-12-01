/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    
    public static String getString(String msg){
        
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print(msg);
            str = sc.nextLine();
            if (!str.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Invalid !");
            }
        }
        return str;
    }
    
}
