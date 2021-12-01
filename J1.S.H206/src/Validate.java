
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Validate {
    
   public static int getInt(String msg){
       Scanner sc = new Scanner(System.in);
       int a = 0;
       while (true) {           
           try {
               System.out.println(msg);
               a = Integer.parseInt(sc.nextLine());
               if(a>0){
                   break;
               }else{
                   System.out.println("Positive number !");
               }
           } catch (Exception e) {
               System.out.println("Invalid !");
           }
       }
       return a;
   }
   
   
   
}
