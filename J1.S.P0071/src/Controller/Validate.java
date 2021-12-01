/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {
    
    private static Scanner sc = new Scanner(System.in);
    
    
    public static int getInt(String msg){
        int a = 0;
        while (true) {            
            try {
                System.out.println(msg);
                a= Integer.parseInt(sc.nextLine());
                if(a>0){
                    break;
                }
            } catch (Exception e) {
            }
        }
        return a;
        
    }

    public static int getChoice(String msg, String err, int min, int max) {
        int a = 0;
        while (true) {
            try {
                System.out.println(msg);
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

    public static int getTask(String str, String err) {

        int a = 0;

        while (true) {
            try {
                System.out.println(str);
                a = Integer.parseInt(sc.nextLine());
                   if(a<=4 && a>=1){
                       break;
                   }
                

            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return a;
    }

    public static String getString(String msg, String err) {
        String str;

        while (true) {
            System.out.println(msg);
            str = sc.nextLine();
            if (!str.trim().isEmpty()) {
                break;
            } else {
                System.out.println(err);
            }
        }
        return str;
    }
   
    public static double getFrom(String msg){
        double from;
        while (true) {            
            try {
                System.out.println(msg);
                from = Double.parseDouble(sc.nextLine());
                if (from>=8&&from<=17.5) {
                    if(from%0.5==0){
                        break;
                    }else{
                        System.out.println("Plan from divisible 0.5 !");
                    }
                }else{
                    System.out.println("Plan from calculate from 8h -> 17h30h .");
                }
            } catch (Exception e) {
                System.out.println("Plan from Invalid !");
            }
        }
        return from;
    }
    
    public static double getTo(String msg, double from){
        double to=0;
        while (true) {            
            try {
                System.out.println(msg);
                to = Double.parseDouble(sc.nextLine());
                if(to>=8&&to<=17.5){
                    if(to%0.5==0){
                        if(to>from){
                            break;
                        }else{
                            System.out.println("to > from");
                        }
                    }else{
                        System.out.println("Plan to divisible by 0.5 !");
                    }
                }else{
                    System.out.println("Plan to calculate 8h -> 17h30.");
                }
            } catch (Exception e) {
                System.out.println("Plan to Invalid!!!");
            }
        }
        return to;
    }


    public static String getSimpleDate(String msg, String err, String format) {
         Date date;
         SimpleDateFormat df = new SimpleDateFormat(format);
        while (true) {
            try {
                System.out.println(msg);
                df.setLenient(false);
                date = df.parse(sc.nextLine());
                break;

            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return df.format(date);
    }
    
}
