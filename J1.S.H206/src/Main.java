/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    
    

    public static void printSquare(int min, int max) {
        
        if(min<0 || max<0){
            min = Validate.getInt("Enter min: ");
            max = Validate.getInt("Enter max: ");
        }
        int minafter = min;
        for (int i = 0; i <= max-minafter; i++) {
 
            for (int j = min; j <= max; j++) {
                System.out.print(j);
            }

            for (int k = minafter; k < min; k++) {
                System.out.print(k);
            }
            System.out.println();
            min = min+1;
        }
    }
    
    public static void main(String[] args) {
//        printSquare(1, 5);
//        printSquare(3, 9);
//        printSquare(0, 3);
//        printSquare(5, 5);
        printSquare(-1, 5);
    }
    
}
