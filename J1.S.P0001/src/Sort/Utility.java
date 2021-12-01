/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;
import java.util.Random;

public class Utility {

    public static int getNumber(String str) {
        int a = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(str);
                a = Integer.parseInt(sc.nextLine());
                if(a>0){
                break;}
            } catch (Exception e) {
                System.out.println("invalid number !!!");
            }
        }
        return a;

    }

    public static int getRandom(int max, int min) {
        if (min >= max) {
            System.out.println("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
