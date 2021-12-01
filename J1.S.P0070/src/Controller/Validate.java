/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int getChoice(String msg, String err, int min, int max) {
        int a = 0;
        while (true) {
            try {
                System.out.print(msg);
                a = Integer.parseInt(sc.nextLine());
                if (a >= min && a <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return a;
    }
    
     public static String getString(String msg) {
        
        String str;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            str = sc.nextLine();
           return str;
        }
        
    }
     
}
